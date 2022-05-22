package com.isi.formation.web.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionListDto {

    private UUID id;

    private String formation;

    private String formateur;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateDebut;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateFin;

}
