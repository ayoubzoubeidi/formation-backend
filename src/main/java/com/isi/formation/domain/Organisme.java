package com.isi.formation.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Organisme extends BaseEntity {

    private String libelle;

    @OneToMany(mappedBy = "organisme")
    private Set<Formateur> formateurs = new HashSet<>();

    @OneToMany(mappedBy = "organisme")
    private Set<Participant> participants = new HashSet<>();

}
