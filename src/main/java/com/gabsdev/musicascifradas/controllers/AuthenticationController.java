package com.gabsdev.musicascifradas.controllers;

import com.gabsdev.musicascifradas.configs.security.TokenService;
import com.gabsdev.musicascifradas.models.usuario.Usuario;
import com.gabsdev.musicascifradas.models.usuario.dto.AuthenticationDTO;
import com.gabsdev.musicascifradas.models.usuario.dto.TokenResponseDTO;
import com.gabsdev.musicascifradas.models.usuario.dto.UsuarioRequestDTO;
import com.gabsdev.musicascifradas.services.interfaces.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioServiceInterface service;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioServiceInterface service) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Validated AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new TokenResponseDTO(
                ((Usuario) auth.getPrincipal()).getNome(),
                ((Usuario) auth.getPrincipal()).getSobrenome(),
                ((Usuario) auth.getPrincipal()).getLogin(),
                ((Usuario) auth.getPrincipal()).getRole(),
                token));
    }

    @PostMapping("/register")
    public <T> ResponseEntity<T> register(@RequestBody @Validated UsuarioRequestDTO data) {
        if (service.loadUserByUsername(data.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario novoUsuario = new Usuario(data.nome(), data.sobrenome(), data.login(),
                encryptedPassword, data.role(), data.dataCriacao(), data.dataAlteracao(), data.flagAtivo());
        service.save(novoUsuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/validate-token")
    public ResponseEntity validateToken() {
        return ResponseEntity.ok(true);
    }
}
