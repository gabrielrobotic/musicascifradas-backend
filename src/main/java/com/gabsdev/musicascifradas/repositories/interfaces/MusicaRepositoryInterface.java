package com.gabsdev.musicascifradas.repositories.interfaces;

import com.gabsdev.musicascifradas.models.musica.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepositoryInterface extends JpaRepository<Musica, Integer> {
}
