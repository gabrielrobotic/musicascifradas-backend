package com.gabsdev.musicascifradas.models.musica.convert;

import com.gabsdev.musicascifradas.models.musica.AcordeSolo;
import com.gabsdev.musicascifradas.models.musica.Solo;
import com.gabsdev.musicascifradas.models.musica.dto.AcordeSoloRequestDTO;
import com.gabsdev.musicascifradas.models.musica.dto.AcordeSoloResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AcordeSoloConverter {
    public static AcordeSoloResponseDTO toResponseDTO(AcordeSolo acordeSolo) {
        return new AcordeSoloResponseDTO(
                acordeSolo.getId(),
                acordeSolo.getCifra(),
                acordeSolo.getEspacamentoDireito(),
                acordeSolo.getEspacamentoEsquerdo(),
                acordeSolo.getOrdenacao());
    }

    public static AcordeSolo toEntity(AcordeSoloRequestDTO dto, Solo solo) {
        AcordeSolo acordeSolo = new AcordeSolo();
        acordeSolo.setCifra(dto.cifra());
        acordeSolo.setEspacamentoDireito(dto.espacamentoDireito());
        acordeSolo.setEspacamentoEsquerdo(dto.espacamentoEsquerdo());
        acordeSolo.setOrdenacao(dto.ordenacao());
        acordeSolo.setSolo(solo);
        return acordeSolo;
    }
}
