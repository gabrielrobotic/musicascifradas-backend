package com.gabsdev.musicascifradas.models.usuario.converter;

import com.gabsdev.musicascifradas.models.usuario.Usuario;
import com.gabsdev.musicascifradas.models.usuario.dto.UsuarioRequestDTO;
import com.gabsdev.musicascifradas.models.usuario.dto.UsuarioResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {
    public static UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getLogin(),
                usuario.getRole(),
                usuario.getDataCriacao(),
                usuario.getDataAlteracao(),
                usuario.getFlagAtivo());
    }

    public static Usuario toEntity(UsuarioRequestDTO dto) {
        return new Usuario(
                dto.nome(),
                dto.sobrenome(),
                dto.login(),
                dto.password(),
                dto.role(),
                dto.dataCriacao(),
                dto.dataAlteracao(),
                dto.flagAtivo()
        );
    }
}
