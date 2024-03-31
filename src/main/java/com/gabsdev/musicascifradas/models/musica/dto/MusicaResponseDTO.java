package com.gabsdev.musicascifradas.models.musica.dto;

import com.gabsdev.musicascifradas.models.usuario.dto.UsuarioResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record MusicaResponseDTO(
        Integer id,
        String titulo,
        String tonalidade,
        String cantor,
        String linkVersao,
        LocalDateTime dataCriacao,
        Boolean flagAtivo,
        List<EstrofeResponseDTO> estrofes,
        List<SoloResponseDTO> solos,
        Integer cifrador) {
}
