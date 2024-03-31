package com.gabsdev.musicascifradas.models.musica.dto;

import java.util.List;

public record SoloRequestDTO(List<AcordeSoloRequestDTO> acordes, Integer ordenacao) {
}
