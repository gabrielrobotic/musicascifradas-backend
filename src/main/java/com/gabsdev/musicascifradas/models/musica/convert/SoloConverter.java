package com.gabsdev.musicascifradas.models.musica.convert;

import com.gabsdev.musicascifradas.models.musica.Musica;
import com.gabsdev.musicascifradas.models.musica.Solo;
import com.gabsdev.musicascifradas.models.musica.dto.SoloRequestDTO;
import com.gabsdev.musicascifradas.models.musica.dto.SoloResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SoloConverter {
    public static SoloResponseDTO toResponseDTO(Solo solo) {
        return new SoloResponseDTO(
                solo.getId(),
                solo.getAcordes().stream()
                        .map(AcordeSoloConverter::toResponseDTO)
                        .toList(),
                solo.getOrdenacao()
        );
    }

    public static Solo toEntity(SoloRequestDTO dto, Musica musica) {
        Solo solo = new Solo();
        solo.setOrdenacao(dto.ordenacao());
        solo.setAcordes(dto.acordes().stream()
                .map(acordeSoloRequestDTO -> AcordeSoloConverter.toEntity(acordeSoloRequestDTO, solo))
                .toList());
        solo.setMusica(musica);
        return solo;
    }
}
