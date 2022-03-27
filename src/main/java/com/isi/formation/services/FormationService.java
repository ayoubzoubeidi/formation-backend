package com.isi.formation.services;

import com.isi.formation.web.models.FormationDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface FormationService {

    URI saveFormation(FormationDto formationDto);

    void updateFormation(FormationDto formationDto, UUID id);

    List<FormationDto> getAllFormation();

    FormationDto getFormationById(UUID formationId);

    void deleteFormationById(UUID formationId);

}
