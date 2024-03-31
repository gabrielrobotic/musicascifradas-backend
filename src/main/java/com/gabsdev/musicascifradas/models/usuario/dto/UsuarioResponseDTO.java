package com.gabsdev.musicascifradas.models.usuario.dto;

import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;

import java.time.LocalDateTime;

public record UsuarioResponseDTO(
        Integer id,
        String primeiroNome,
        String segundoNome,
        String login,
        UsuarioRole role,
        LocalDateTime dataCriacao,
        Boolean flagAtivo) {
}
