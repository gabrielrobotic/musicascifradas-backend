package com.gabsdev.musicascifradas.models.musica.dto;

import java.util.List;

public record VersoRequestDTO(String texto, List<AcordeVersoRequestDTO> acordes, Integer ordenacao) {
}
