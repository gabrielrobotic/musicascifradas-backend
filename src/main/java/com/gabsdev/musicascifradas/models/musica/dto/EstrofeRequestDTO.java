package com.gabsdev.musicascifradas.models.musica.dto;

import java.util.List;

public record EstrofeRequestDTO(List<VersoRequestDTO> versos, Integer ordenacao) {
}
