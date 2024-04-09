package com.gabsdev.musicascifradas.models.usuario.dto;

import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;

public record TokenResponseDTO(String nome, String sobrenome, String username, UsuarioRole role, String token) {
}
