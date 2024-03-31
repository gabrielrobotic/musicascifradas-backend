package com.gabsdev.musicascifradas.services.interfaces;

import com.gabsdev.musicascifradas.models.musica.Musica;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MusicaServiceInterface {

    void salvar(Musica musica);

    public Musica obterMusicaPorId(Integer id);

    public Page<Musica> obterMusicas(Example<Musica> filtro, Pageable pageable);

    public void excluirPorId(Integer id);
}
