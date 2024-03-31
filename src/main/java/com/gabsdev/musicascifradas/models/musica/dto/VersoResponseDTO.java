package com.gabsdev.musicascifradas.models.musica.dto;

import java.util.List;

public record VersoResponseDTO(Integer id, String texto, List<AcordeVersoResponseDTO> acordes, Integer ordenacao) {
}
