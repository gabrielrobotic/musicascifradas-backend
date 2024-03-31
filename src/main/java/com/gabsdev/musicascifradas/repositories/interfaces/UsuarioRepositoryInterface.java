package com.gabsdev.musicascifradas.repositories.interfaces;

import com.gabsdev.musicascifradas.models.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositoryInterface extends JpaRepository<Usuario, Integer> {
    public Usuario findByLogin(String login);
}
