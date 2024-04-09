package com.gabsdev.musicascifradas.models.usuario.example;

import com.gabsdev.musicascifradas.models.usuario.Usuario;
import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.time.LocalDateTime;

public class UsuarioExample {
    public static Example<Usuario> buildExample(String nome, String sobrenome,
                                                String username, UsuarioRole role, LocalDateTime dataCriacao,
                                                LocalDateTime dataAlteracao, Boolean flagAtivo) {
        Usuario example = new Usuario();
        example.setNome(nome);
        example.setSobrenome(sobrenome);
        example.setLogin(username);
        example.setRole(role);
        example.setDataCriacao(dataCriacao);
        example.setDataCriacao(dataAlteracao);
        example.setFlagAtivo(flagAtivo);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return Example.of(example, matcher);
    }
}
