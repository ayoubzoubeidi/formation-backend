package com.isi.formation.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Session extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "organisme_id")
    private Organisme organisme;

    private Date dateDebut;

    private Date dateFin;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    @ManyToMany
    @JoinTable(name = "formation_session",
            joinColumns = {@JoinColumn(name = "session_id")},
            inverseJoinColumns = {@JoinColumn(name = "formation_id")})
    private Set<Formation> formations = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "participation",
            joinColumns = {@JoinColumn(name = "session_id")},
            inverseJoinColumns = {@JoinColumn(name = "participant_id")})
    private Set<Participant> participants = new HashSet<>();

}
