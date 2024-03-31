package com.gabsdev.musicascifradas.models.musica.convert;

import com.gabsdev.musicascifradas.models.musica.Estrofe;
import com.gabsdev.musicascifradas.models.musica.Musica;
import com.gabsdev.musicascifradas.models.musica.dto.EstrofeRequestDTO;
import com.gabsdev.musicascifradas.models.musica.dto.EstrofeResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class EstrofeConverter {

    public static EstrofeResponseDTO toResponseDTO(Estrofe estrofe) {
        return new EstrofeResponseDTO(
                estrofe.getId(),
                estrofe.getVersos().stream()
                        .map(VersoConverter::toResponseDTO)
                        .toList(),
                estrofe.getOrdenacao());
    }

    public static Estrofe toEntity(EstrofeRequestDTO dto, Musica musica) {
        Estrofe estrofe = new Estrofe();
        estrofe.setOrdenacao(dto.ordenacao());
        estrofe.setVersos(dto.versos().stream()
                .map(versoRequestDTO -> VersoConverter.toEntity(versoRequestDTO, estrofe))
                .toList());
        estrofe.setMusica(musica);
        return estrofe;
    }
}
