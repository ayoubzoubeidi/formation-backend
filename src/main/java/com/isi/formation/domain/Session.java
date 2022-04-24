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

@NamedEntityGraph(name = "Sessions.all",
        attributeNodes = {@NamedAttributeNode("organisme"), @NamedAttributeNode("formation"),
                @NamedAttributeNode("formateur"), @NamedAttributeNode("participants")}
)
public class Session extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "organisme_id")
    private Organisme organisme;

    private Date dateDebut;

    private Date dateFin;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "formateur_id")
    private Formateur formateur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "participation",
            joinColumns = {@JoinColumn(name = "session_id")},
            inverseJoinColumns = {@JoinColumn(name = "participant_id")})
    private Set<Participant> participants = new HashSet<>();

}
