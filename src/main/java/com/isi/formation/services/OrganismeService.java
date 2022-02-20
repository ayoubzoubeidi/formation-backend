package com.isi.formation.services;

import com.isi.formation.web.models.OrganismeDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface OrganismeService {

    URI saveOrganisme(OrganismeDto OrganismeDto);

    void updateOrganisme(OrganismeDto OrganismeDto);

    List<OrganismeDto> getAllOrganisme();

    OrganismeDto getOrganismeById(UUID OrganismeId);

    void deleteOrganismeById(UUID OrganismeId);
    
}
