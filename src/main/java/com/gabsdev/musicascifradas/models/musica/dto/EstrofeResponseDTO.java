package com.gabsdev.musicascifradas.models.musica.dto;

import java.util.List;

public record EstrofeResponseDTO(Integer id, List<VersoResponseDTO> versos, Integer ordenacao) {
}
