package com.gabsdev.musicascifradas.services;

import com.gabsdev.musicascifradas.models.musica.Musica;
import com.gabsdev.musicascifradas.repositories.interfaces.MusicaRepositoryInterface;
import com.gabsdev.musicascifradas.services.interfaces.MusicaServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MusicaService implements MusicaServiceInterface {
    private final MusicaRepositoryInterface repository;

    @Autowired
    public MusicaService(MusicaRepositoryInterface repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(Musica musica) {
        this.repository.save(musica);
    }

    @Override
    public Musica obterMusicaPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Musica> obterMusicas(Example<Musica> filtro, Pageable pageable) {
        return repository.findAll(filtro, pageable);
    }

    @Override
    public void excluirPorId(Integer id) {
        repository.deleteById(id);
    }
}
