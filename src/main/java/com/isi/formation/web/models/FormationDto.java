package com.isi.formation.web.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FormationDto {

    private UUID id;

    private String titre;

    private String typeFormation;

    private List<SessionDto> sessions = new ArrayList<>();

    private Integer duree;

    private DomaineDto domaine;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal budget;

}
