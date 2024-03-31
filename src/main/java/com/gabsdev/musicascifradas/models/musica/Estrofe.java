package com.gabsdev.musicascifradas.models.musica;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "estrofe")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Estrofe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estrofe_id_seq")
    @SequenceGenerator(name = "estrofe_id_seq", sequenceName = "estrofe_id_seq", allocationSize = 1)
    private Integer id;
    @OneToMany(mappedBy = "estrofe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Verso> versos;
    private Integer ordenacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "musica_fk")
    private Musica musica;
}
