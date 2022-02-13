package com.isi.formation.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Participant extends BaseEntity{

    private String nom;

    private String prenom;

    private TypeParticipant typeParticipant;

    @ManyToOne
    @JoinColumn(name = "organisme_id")
    private Organisme organisme;

    @ManyToMany(mappedBy = "participants")
    private Set<Session> sessions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    private String email;

    private String tel;

}
