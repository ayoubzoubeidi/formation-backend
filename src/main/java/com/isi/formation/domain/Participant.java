package com.isi.formation.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedEntityGraph(name = "Participants.all",
        attributeNodes = {@NamedAttributeNode("organisme"),
                @NamedAttributeNode(value = "sessions", subgraph = "sessions-sub")}, subgraphs = {
        @NamedSubgraph(
                name = "sessions-sub", attributeNodes = {@NamedAttributeNode("organisme"), @NamedAttributeNode("formation"),
                @NamedAttributeNode("formateur")}
        )
}
)

@Entity
public class Participant extends BaseEntity{

    private String nom;

    private String prenom;

    private TypeParticipant typeParticipant;

    @ManyToOne
    @JoinColumn(name = "organisme_id")
    private Organisme organisme;

    @ManyToMany(mappedBy = "participants", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @Singular
    private Set<Session> sessions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;

    private String email;

    private String tel;


}
