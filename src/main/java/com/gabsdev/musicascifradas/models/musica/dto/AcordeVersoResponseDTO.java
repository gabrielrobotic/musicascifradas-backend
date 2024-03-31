package com.gabsdev.musicascifradas.models.musica.dto;

public record AcordeVersoResponseDTO(
        Integer id,
        String cifra,
        Double espacamentoDireito,
        Double espacamentoEsquerdo,
        Integer ordenacao) {
}
