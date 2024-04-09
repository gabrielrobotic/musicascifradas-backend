package com.gabsdev.musicascifradas.models.musica.convert;

import com.gabsdev.musicascifradas.models.musica.Musica;
import com.gabsdev.musicascifradas.models.musica.dto.MusicaRequestDTO;
import com.gabsdev.musicascifradas.models.musica.dto.MusicaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class MusicaConverter {

    public static MusicaResponseDTO toResponseDTO(Musica musica) {
        return new MusicaResponseDTO(
                musica.getId(),
                musica.getTitulo(),
                musica.getTonalidade(),
                musica.getCantor(),
                musica.getLinkVersao(),
                musica.getDataCriacao(),
                musica.getDataAlteracao(),
                musica.getFlagAtivo(),
                musica.getEstrofes().stream()
                        .map(EstrofeConverter::toResponseDTO)
                        .toList(),
                musica.getSolos().stream()
                        .map(SoloConverter::toResponseDTO)
                        .toList(),
                musica.getCifrador());
    }

    public static Musica toEntity(MusicaRequestDTO musicaRequestDTO) {
        Musica musica = new Musica();
        musica.setTitulo(musicaRequestDTO.titulo());
        musica.setTonalidade(musicaRequestDTO.tonalidade());
        musica.setCantor(musicaRequestDTO.cantor());
        musica.setLinkVersao(musicaRequestDTO.linkVersao());
        musica.setDataCriacao(musicaRequestDTO.dataCriacao());
        musica.setDataAlteracao(musicaRequestDTO.dataAlteracao());
        musica.setFlagAtivo(musicaRequestDTO.flagAtivo());
        musica.setSolos(musicaRequestDTO.solos().stream()
                .map(soloRequestDTO -> SoloConverter.toEntity(soloRequestDTO, musica))
                .toList());
        musica.setEstrofes(musicaRequestDTO.estrofes().stream()
                .map(estrofeRequestDTO -> EstrofeConverter.toEntity(estrofeRequestDTO, musica))
                .toList());
        musica.setCifrador(musicaRequestDTO.cifrador());
        return musica;
    }
}
