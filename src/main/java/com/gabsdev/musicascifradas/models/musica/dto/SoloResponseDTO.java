package com.gabsdev.musicascifradas.models.musica.dto;

import java.util.List;

public record SoloResponseDTO(Integer id, List<AcordeSoloResponseDTO> acordes, Integer ordenacao) {
}
