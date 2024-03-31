package com.gabsdev.musicascifradas.models.musica;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "verso")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Verso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "verso_id_seq")
    @SequenceGenerator(name = "verso_id_seq", sequenceName = "verso_id_seq", allocationSize = 1)
    private Integer id;
    private String texto;
    @OneToMany(mappedBy = "verso", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<AcordeVerso> acordes;
    private Integer ordenacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "estrofe_fk")
    private Estrofe estrofe;
}
