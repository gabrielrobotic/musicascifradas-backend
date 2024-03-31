package com.gabsdev.musicascifradas.services;

import com.gabsdev.musicascifradas.models.usuario.Usuario;
import com.gabsdev.musicascifradas.repositories.interfaces.UsuarioRepositoryInterface;
import com.gabsdev.musicascifradas.services.interfaces.UsuarioServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService, UsuarioServiceInterface {

    @Autowired
    UsuarioRepositoryInterface repository;

    @Override
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    @Override
    public void save(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public Page<Usuario> obterUsuarios(Example<Usuario> filtro, Pageable pageable) {
        return repository.findAll(filtro, pageable);
    }

    @Override
    public Usuario obterPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void excluirPorId(Integer id) {
        repository.deleteById(id);
    }

}
