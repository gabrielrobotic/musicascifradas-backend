package com.gabsdev.musicascifradas.models.usuario.dto;

import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(
        Integer id,
        String nome,
        String sobrenome,
        String login,
        UsuarioRole role,
        LocalDateTime dataCriacao,
        LocalDateTime dataAlteracao,
        Boolean flagAtivo) {
}
