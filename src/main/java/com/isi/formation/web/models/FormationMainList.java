package com.isi.formation.web.models;

import lombok.Data;

import java.util.UUID;

@Data
public class FormationMainList {

    private final UUID id;
    private final String titre;
    private final String domaine;

}
