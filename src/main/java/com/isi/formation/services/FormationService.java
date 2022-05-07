package com.isi.formation.services;

import com.isi.formation.web.models.FormationDto;
import com.isi.formation.web.models.FormationMainList;
import com.isi.formation.web.models.SessionDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface FormationService {

    URI saveFormation(FormationDto formationDto);

    void updateFormation(FormationDto formationDto, UUID id);

    List<FormationMainList> getAllFormation();

    List<SessionDto> getAllSessionsByFormation(UUID formationId);

    FormationDto getFormationById(UUID formationId);

    void deleteFormationById(UUID formationId);

}
