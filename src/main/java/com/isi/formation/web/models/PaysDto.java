package com.isi.formation.web.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaysDto {

    private UUID id;

    private String nom;

}
