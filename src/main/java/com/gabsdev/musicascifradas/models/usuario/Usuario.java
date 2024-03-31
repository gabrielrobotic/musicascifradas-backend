package com.gabsdev.musicascifradas.models.usuario;

import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Table(name = "usuario")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
    private Integer id;
    private String primeiroNome;
    private String segundoNome;
    private String login;
    private String password;
    private UsuarioRole role;
    private LocalDateTime dataCriacao;
    private Boolean flagAtivo;

    public Usuario(String primeiroNome, String segundoNome, String login, String password, UsuarioRole role,
                   LocalDateTime dataCriacao, Boolean flagAtivo) {
        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.login = login;
        this.password = password;
        this.role = role;
        this.dataCriacao = dataCriacao;
        this.flagAtivo = flagAtivo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role.equals(UsuarioRole.ADMIN))
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USUARIO"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
