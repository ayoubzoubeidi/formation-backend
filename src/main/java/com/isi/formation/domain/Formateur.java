package com.isi.formation.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Formateur extends BaseEntity {

    private String nom;

    private String prenom;

    private String email;

    private String tel;

    @OneToMany(mappedBy = "formateur")
    private Set<Session> sessions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    @ManyToOne
    @JoinColumn(name = "organisme_id")
    private Organisme organisme;

    private TypeFormateur typeFormateur;

}
