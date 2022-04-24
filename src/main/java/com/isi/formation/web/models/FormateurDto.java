package com.isi.formation.web.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
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
