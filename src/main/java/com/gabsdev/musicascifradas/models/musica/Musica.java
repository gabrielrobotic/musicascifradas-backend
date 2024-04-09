package com.gabsdev.musicascifradas.models.musica;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "musica")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "musica_id_seq")
    @SequenceGenerator(name = "musica_id_seq", sequenceName = "musica_id_seq", allocationSize = 1)
    private Integer id;
    private String titulo;
    private String tonalidade;
    private String cantor;
    private String linkVersao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
    private Boolean flagAtivo;
    @OneToMany(mappedBy = "musica", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Estrofe> estrofes;
    @OneToMany(mappedBy = "musica", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Solo> solos;
    @Column(name = "cifrador_fk")
    private Integer cifrador;
}
