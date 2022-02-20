package com.isi.formation.services;

import com.isi.formation.domain.Organisme;
import com.isi.formation.mappers.OrganismeMapper;
import com.isi.formation.repository.OrganismeRepository;
import com.isi.formation.web.models.OrganismeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganismeServiceImpl implements OrganismeService {

    private final OrganismeRepository organismeRepository;
    private final OrganismeMapper organismeMapper;

    @Override
    public URI saveOrganisme(OrganismeDto organismeDto) {
        Organisme organisme = organismeRepository.save(organismeMapper.organismeDtoToOrganisme(organismeDto));

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(organisme.getId()).toUri();
    }

    @Override
    public void updateOrganisme(OrganismeDto organismeDto) {
        Organisme savedOrganisme = organismeRepository.findById(organismeDto.getId()).orElseThrow(RuntimeException::new);

        savedOrganisme.setLibelle(organismeDto.getLibelle());

        organismeRepository.save(savedOrganisme);

    }

    @Override
    public List<OrganismeDto> getAllOrganisme() {
        return organismeRepository.findAll()
                .stream()
                .map(organismeMapper::organismeToOrganismeDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrganismeDto getOrganismeById(UUID organismeId) {
        Organisme savedOrganisme = organismeRepository.findById(organismeId).orElseThrow(RuntimeException::new);
        return organismeMapper.organismeToOrganismeDto(savedOrganisme);
    }

    @Override
    public void deleteOrganismeById(UUID organismeId) {
        organismeRepository.deleteById(organismeId);
    }
}
