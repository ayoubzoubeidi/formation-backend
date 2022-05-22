package com.isi.formation.web.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantDto {

    private UUID id;

    private String nom;

    private String prenom;

    private String typeParticipant;

    private OrganismeDto organisme;

    private List<SessionDto> sessions = new ArrayList<>();

    private PaysDto pays;

    private String email;

    private String tel;
}
