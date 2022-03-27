package com.isi.formation.services;

import com.isi.formation.web.models.DomaineDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface DomaineService {

    URI saveDomaine(DomaineDto domaineDto);

    void updateDomaine(DomaineDto domaineDto, UUID id);

    List<DomaineDto> getAllDomaine();

    DomaineDto getDomaineById(UUID domaineId);

    void deleteDomaineById(UUID domaineId);
}
