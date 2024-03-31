package com.gabsdev.musicascifradas.models.musica.dto;

import com.gabsdev.musicascifradas.models.usuario.dto.UsuarioRequestDTO;

import java.time.LocalDateTime;
import java.util.List;

public record MusicaRequestDTO(
        String titulo,
        String tonalidade,
        String cantor,
        String linkVersao,
        LocalDateTime dataCriacao,
        Boolean flagAtivo,
        List<EstrofeRequestDTO> estrofes,
        List<SoloRequestDTO> solos,
        Integer cifrador) {
}
