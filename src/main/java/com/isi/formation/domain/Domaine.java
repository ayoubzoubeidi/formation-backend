package com.isi.formation.domain;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Domaine extends BaseEntity {

    private String libelle;

}
