package com.gabsdev.musicascifradas.models.musica.convert;

import com.gabsdev.musicascifradas.models.musica.AcordeVerso;
import com.gabsdev.musicascifradas.models.musica.Verso;
import com.gabsdev.musicascifradas.models.musica.dto.AcordeVersoRequestDTO;
import com.gabsdev.musicascifradas.models.musica.dto.AcordeVersoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AcordeVersoConverter {
    public static AcordeVersoResponseDTO toResponseDTO(AcordeVerso acordeVerso) {
        return new AcordeVersoResponseDTO(
                acordeVerso.getId(),
                acordeVerso.getCifra(),
                acordeVerso.getEspacamentoDireito(),
                acordeVerso.getEspacamentoEsquerdo(),
                acordeVerso.getOrdenacao());
    }

    public static AcordeVerso toEntity(AcordeVersoRequestDTO dto, Verso verso) {
        AcordeVerso acordeVerso = new AcordeVerso();
        acordeVerso.setCifra(dto.cifra());
        acordeVerso.setEspacamentoDireito(dto.espacamentoDireito());
        acordeVerso.setEspacamentoEsquerdo(dto.espacamentoEsquerdo());
        acordeVerso.setOrdenacao(dto.ordenacao());
        acordeVerso.setVerso(verso);
        return acordeVerso;
    }
}
