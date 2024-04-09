package com.gabsdev.musicascifradas.models.musica.dto;

import java.time.LocalDateTime;
import java.util.List;

public record MusicaRequestDTO(
        String titulo,
        String tonalidade,
        String cantor,
        String linkVersao,
        LocalDateTime dataCriacao,
        LocalDateTime dataAlteracao,
        Boolean flagAtivo,
        List<EstrofeRequestDTO> estrofes,
        List<SoloRequestDTO> solos,
        Integer cifrador) {
}
