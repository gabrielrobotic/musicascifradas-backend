package com.gabsdev.musicascifradas.models.musica.convert;

import com.gabsdev.musicascifradas.models.musica.Estrofe;
import com.gabsdev.musicascifradas.models.musica.Verso;
import com.gabsdev.musicascifradas.models.musica.dto.VersoRequestDTO;
import com.gabsdev.musicascifradas.models.musica.dto.VersoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class VersoConverter {

    public static VersoResponseDTO toResponseDTO(Verso verso) {
        return new VersoResponseDTO(
                verso.getId(),
                verso.getTexto(),
                verso.getAcordes().stream()
                        .map(AcordeVersoConverter::toResponseDTO)
                        .toList(),
                verso.getOrdenacao());
    }

    public static Verso toEntity(VersoRequestDTO dto, Estrofe estrofe) {
        Verso verso = new Verso();
        verso.setTexto(dto.texto());
        verso.setOrdenacao(dto.ordenacao());
        verso.setAcordes(dto.acordes().stream()
                .map(acordeVersoRequestDTO -> AcordeVersoConverter.toEntity(acordeVersoRequestDTO, verso))
                .toList());
        verso.setEstrofe(estrofe);
        return verso;
    }
}
