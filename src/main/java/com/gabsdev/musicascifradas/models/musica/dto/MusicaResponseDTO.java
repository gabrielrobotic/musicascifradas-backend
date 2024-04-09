package com.gabsdev.musicascifradas.models.musica.dto;

import java.time.LocalDateTime;
import java.util.List;

public record MusicaResponseDTO(
        Integer id,
        String titulo,
        String tonalidade,
        String cantor,
        String linkVersao,
        LocalDateTime dataCriacao,
        LocalDateTime dataAlteracao,
        Boolean flagAtivo,
        List<EstrofeResponseDTO> estrofes,
        List<SoloResponseDTO> solos,
        Integer cifrador) {
}
