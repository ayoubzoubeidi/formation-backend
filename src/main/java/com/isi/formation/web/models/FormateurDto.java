package com.isi.formation.web.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormateurDto {

    private UUID id;

    private String nom;

    private String prenom;

    private String email;

    private String tel;

    private OrganismeDto organisme;

    private String typeFormateur;

}
