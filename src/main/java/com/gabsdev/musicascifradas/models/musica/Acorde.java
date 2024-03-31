package com.gabsdev.musicascifradas.models.musica;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "acorde")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("acorde")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Acorde {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acorde_id_seq")
    @SequenceGenerator(name = "acorde_id_seq", sequenceName = "acorde_id_seq", allocationSize = 1)
    private Integer id;
    private String cifra;
    private Double espacamentoDireito;
    private Double espacamentoEsquerdo;
    private Integer ordenacao;
}
