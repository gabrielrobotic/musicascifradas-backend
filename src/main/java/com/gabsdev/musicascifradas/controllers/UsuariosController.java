package com.gabsdev.musicascifradas.controllers;

import com.gabsdev.musicascifradas.models.usuario.example.UsuarioExample;
import com.gabsdev.musicascifradas.models.usuario.Usuario;
import com.gabsdev.musicascifradas.models.usuario.converter.UsuarioConverter;
import com.gabsdev.musicascifradas.models.usuario.dto.UsuarioRequestDTO;
import com.gabsdev.musicascifradas.models.usuario.dto.UsuarioResponseDTO;
import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;
import com.gabsdev.musicascifradas.services.interfaces.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuarioServiceInterface service;

    @Autowired
    public UsuariosController(UsuarioServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> usuarios(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "sobrenome", required = false) String sobrenome,
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "role", required = false) UsuarioRole role,
            @RequestParam(name = "dataCriacao", required = false) LocalDateTime dataCriacao,
            @RequestParam(name = "dataAlteracao", required = false) LocalDateTime dataAlteracao,
            @RequestParam(name = "flagAtivo", required = false) Boolean flagAtivo) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
        Example<Usuario> example = UsuarioExample.buildExample(
                nome,
                sobrenome,
                username,
                role,
                dataCriacao,
                dataAlteracao,
                flagAtivo);
        Page<UsuarioResponseDTO> usuarios = service.obterUsuarios(example, pageable)
                .map(UsuarioConverter::toResponseDTO);
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public <T> ResponseEntity<T> salvar(@RequestBody @Validated UsuarioRequestDTO data) {
        if (service.loadUserByUsername(data.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario novoUsuario = new Usuario(data.nome(), data.sobrenome(), data.login(),
                encryptedPassword, data.role(), data.dataCriacao(), data.dataAlteracao(), data.flagAtivo());
        service.save(novoUsuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public <T> ResponseEntity<T> atualizar(
            @PathVariable(name = "id") @Validated Integer id,
            @RequestBody @Validated UsuarioRequestDTO data) {
        var usuarioPeloLogin = service.loadUserByUsername(data.login());
        var usuarioPeloId = service.obterPorId(id);
        if ((usuarioPeloLogin != null && usuarioPeloLogin.getUsername().equals(data.login()))
                || usuarioPeloId == null)
            return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario usuarioAtualizar = new Usuario(id, data.nome(), data.sobrenome(), data.login(),
                encryptedPassword, data.role(), data.dataCriacao(), data.dataAlteracao(), data.flagAtivo());
        service.save(usuarioAtualizar);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public <T> ResponseEntity<T> excluir(@PathVariable(name = "id") @Validated Integer id) {
        var usuario = service.obterPorId(id);
        if (usuario != null) return ResponseEntity.badRequest().build();
        service.excluirPorId(id);
        return ResponseEntity.ok().build();
    }
}
