package com.isi.formation.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Formation extends BaseEntity {

    private String titre;

    private String typeFormation;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    @OneToMany(mappedBy = "formation")
    private Set<Session> sessions = new HashSet<>();

    private Integer duree;

    @ManyToOne
    @JoinColumn(name = "domaine_id")
    private Domaine domaine;

    private BigDecimal budget;

}
