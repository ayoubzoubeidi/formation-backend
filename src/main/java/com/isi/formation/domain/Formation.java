package com.isi.formation.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

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
    @JoinColumn(name = "session_id")
    private Session session;

    private Integer duree;

    @ManyToOne
    @JoinColumn(name = "domaine_id")
    private Domaine domaine;

    private BigDecimal budget;

}
