package com.isi.formation.services;

import com.isi.formation.web.models.FormateurDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface FormateurService {

    URI saveFormateur(FormateurDto formationDto);

    void updateFormateur(FormateurDto formationDto, UUID id);

    List<FormateurDto> getAllFormateur();

    FormateurDto getFormateurById(UUID FormateurId);

    void deleteFormateurById(UUID FormateurId);


}
