package com.gabsdev.musicascifradas.models.musica.example;

import com.gabsdev.musicascifradas.models.musica.Musica;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.time.LocalDateTime;

public class MusicaExample {
    public static Example<Musica> buildExample(String titulo, String cantor, LocalDateTime dataCriacao,
                                               LocalDateTime dataAlteracao, Boolean flagAtivo, Integer cifrador) {
        Musica example = new Musica();
        example.setTitulo(titulo);
        example.setCantor(cantor);
        example.setDataCriacao(dataCriacao);
        example.setDataCriacao(dataAlteracao);
        example.setFlagAtivo(flagAtivo);
        example.setCifrador(cifrador);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        return Example.of(example, matcher);
    }
}
