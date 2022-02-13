package com.isi.formation.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Formateur extends BaseEntity {

    private String nom;

    private String prenom;

    private String email;

    private String tel;

    @ManyToOne
    @JoinColumn(name = "organisme_id")
    private Organisme organisme;

    private TypeFormateur typeFormateur;

}
