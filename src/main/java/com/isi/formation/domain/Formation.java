package com.isi.formation.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "formation")
    private Set<Session> sessions = new HashSet<>();

    private Integer duree;

    @ManyToOne
    @JoinColumn(name = "domaine_id")
    private Domaine domaine;

    private BigDecimal budget;

}
