package com.gabsdev.musicascifradas.models.usuario.dto;

import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;

import java.time.LocalDateTime;

public record UsuarioRequestDTO(
        String primeiroNome,
        String segundoNome,
        String login,
        String password,
        UsuarioRole role,
        LocalDateTime dataCriacao,
        Boolean flagAtivo) {
}
