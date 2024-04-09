package com.gabsdev.musicascifradas.models.usuario.dto;

import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;

import java.time.LocalDateTime;

public record UsuarioRequestDTO(
        String nome,
        String sobrenome,
        String login,
        String password,
        UsuarioRole role,
        LocalDateTime dataCriacao,
        LocalDateTime dataAlteracao,
        Boolean flagAtivo) {
}
