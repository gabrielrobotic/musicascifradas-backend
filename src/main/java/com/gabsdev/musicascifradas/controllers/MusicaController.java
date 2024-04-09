package com.gabsdev.musicascifradas.controllers;

import com.gabsdev.musicascifradas.models.musica.Musica;
import com.gabsdev.musicascifradas.models.musica.convert.MusicaConverter;
import com.gabsdev.musicascifradas.models.musica.dto.MusicaRequestDTO;
import com.gabsdev.musicascifradas.models.musica.dto.MusicaResponseDTO;
import com.gabsdev.musicascifradas.models.musica.example.MusicaExample;
import com.gabsdev.musicascifradas.services.MusicaService;
import com.gabsdev.musicascifradas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    private final MusicaService service;
    private final UsuarioService usuarioService;

    @Autowired
    public MusicaController(MusicaService service, UsuarioService usuarioService) {
        this.service = service;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody @Validated MusicaRequestDTO data) {
        service.salvar(MusicaConverter.toEntity(data));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicaResponseDTO> obterPorId(@PathVariable(name = "id") @Validated Integer id) {
        var musica = service.obterMusicaPorId(id);
        MusicaResponseDTO responseDTO = musica != null ?
                MusicaConverter.toResponseDTO(musica) : null;
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{id}")
    public <T> ResponseEntity<T> atualizar(
            @PathVariable(name = "id") @Validated Integer id,
            @RequestBody @Validated MusicaRequestDTO data) {
        Musica musica = service.obterMusicaPorId(id);
        if (musica == null) return ResponseEntity.badRequest().build();
        musica = MusicaConverter.toEntity(data);
        musica.setId(id);
        service.salvar(musica);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<MusicaResponseDTO>> obterMusicas(
            @RequestParam(name = "titulo", required = false) String titulo,
            @RequestParam(name = "cantor", required = false) String cantor,
            @RequestParam(name = "dataCriacao", required = false) LocalDateTime dataCriacao,
            @RequestParam(name = "dataAlteracao", required = false) LocalDateTime dataAlteracao,
            @RequestParam(name = "flagAtivo", required = false) Boolean flagAtivo,
            @RequestParam(name = "cifrador", required = false) Integer cifrador) {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").ascending());
        Example<Musica> example = MusicaExample.buildExample(
                titulo,
                cantor,
                dataCriacao,
                dataAlteracao,
                flagAtivo,
                cifrador);
        Page<MusicaResponseDTO> musicas = service.obterMusicas(example, pageable)
                .map(musica -> MusicaConverter.toResponseDTO(musica));
        return ResponseEntity.ok(musicas);
    }

    @DeleteMapping("/{id}")
    public <T> ResponseEntity<T> excluir(@PathVariable(name = "id") @Validated Integer id) {
        service.excluirPorId(id);
        return ResponseEntity.ok().build();
    }
}
