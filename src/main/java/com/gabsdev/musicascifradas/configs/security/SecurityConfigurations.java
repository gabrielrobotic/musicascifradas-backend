package com.gabsdev.musicascifradas.configs.security;

import com.gabsdev.musicascifradas.models.usuario.enumeration.UsuarioRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/auth/validate-token").hasRole(
                                UsuarioRole.USUARIO.name())
                        .requestMatchers(HttpMethod.GET, "/usuarios").hasRole(
                                UsuarioRole.ADMIN.name())
                        .requestMatchers(HttpMethod.POST, "/usuarios").hasRole(
                                UsuarioRole.USUARIO.name())
                        .requestMatchers(HttpMethod.PUT, "/usuarios/{id}").hasRole(
                                UsuarioRole.USUARIO.name())
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/{id}").hasRole(
                                UsuarioRole.USUARIO.name())
                        .requestMatchers(HttpMethod.GET, "/musicas").hasRole(
                                UsuarioRole.USUARIO.name())
                        .requestMatchers(HttpMethod.POST, "/musicas").hasRole(
                                UsuarioRole.USUARIO.name())
                        .requestMatchers(HttpMethod.GET, "/musicas/{id}").hasRole(
                                UsuarioRole.USUARIO.name())
                        .requestMatchers(HttpMethod.PUT, "/musicas/{id}").hasRole(
                                UsuarioRole.USUARIO.name())
                        .requestMatchers(HttpMethod.DELETE, "/musicas/{id}").hasRole(
                                UsuarioRole.USUARIO.name())
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
