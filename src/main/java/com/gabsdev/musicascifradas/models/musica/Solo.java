package com.gabsdev.musicascifradas.models.musica;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "solo")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Solo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solo_id_seq")
    @SequenceGenerator(name = "solo_id_seq", sequenceName = "solo_id_seq", allocationSize = 1)
    private Integer id;
    @OneToMany(mappedBy = "solo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AcordeSolo> acordes;
    private Integer ordenacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "musica_fk")
    private Musica musica;
}
