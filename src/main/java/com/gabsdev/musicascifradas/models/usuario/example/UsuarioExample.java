package com.gabsdev.musicascifradas.models.usuario.example;

import com.gabsdev.musicascifradas.models.usuario.Usuario;
import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.time.LocalDateTime;

public class UsuarioExample {
    public static Example<Usuario> buildExample(String primeiroNome, String segundoNome,
                                                String username, UsuarioRole role, LocalDateTime dataCriacao,
                                                Boolean flagAtivo) {
        Usuario example = new Usuario();
        example.setPrimeiroNome(primeiroNome);
        example.setSegundoNome(segundoNome);
        example.setLogin(username);
        example.setRole(role);
        example.setDataCriacao(dataCriacao);
        example.setFlagAtivo(flagAtivo);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return Example.of(example, matcher);
    }
}
