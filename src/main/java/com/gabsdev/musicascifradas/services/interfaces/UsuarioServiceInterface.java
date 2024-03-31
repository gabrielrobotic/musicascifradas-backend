package com.gabsdev.musicascifradas.services.interfaces;

import com.gabsdev.musicascifradas.models.usuario.Usuario;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UsuarioServiceInterface {
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public void save(Usuario usuario);

    public Page<Usuario> obterUsuarios(Example<Usuario> filtro, Pageable pageable);

    public Usuario obterPorId(Integer id);

    public void excluirPorId(Integer id);
}
