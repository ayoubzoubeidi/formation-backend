package com.isi.formation.services;

import com.isi.formation.domain.Formation;
import com.isi.formation.mappers.FormationMapper;
import com.isi.formation.mappers.SessionMapper;
import com.isi.formation.repository.FormationRepository;
import com.isi.formation.web.models.FormationDto;
import com.isi.formation.web.models.FormationMainList;
import com.isi.formation.web.models.SessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FormationServiceImpl implements FormationService {


    private final FormationRepository formationRepository;
    private final FormationMapper formationMapper;
    private final SessionMapper sessionMapper;

    @Override
    public URI saveFormation(FormationDto formationDto) {
        Formation formation = formationRepository.save(formationMapper.formationDtoToFormation(formationDto));

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(formation.getId()).toUri();
    }

    @Override
    public void updateFormation(FormationDto formationDto, UUID id) {
        Formation savedFormation = formationRepository.findById(id).orElseThrow(RuntimeException::new);

        savedFormation.setDuree(formationDto.getDuree());
        savedFormation.setBudget(formationDto.getBudget());
        savedFormation.setTitre(formationDto.getTitre());

        formationRepository.save(savedFormation);

    }

    @Override
    @Cacheable("formations")
    public List<FormationMainList> getAllFormation() {
        return formationRepository.findAllFormationList();
    }

    @Override
    public List<SessionDto> getAllSessionsByFormation(UUID formationId) {
        return formationRepository.findAllSessionsByFormationId(formationId)
                .stream()
                .map(sessionMapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    @Override
    public FormationDto getFormationById(UUID formationId) {
        Formation savedFormation = formationRepository.findById(formationId).orElseThrow(RuntimeException::new);
        return formationMapper.formationToFormationDto(savedFormation);
    }

    @Override
    public void deleteFormationById(UUID formationId) {
        formationRepository.deleteById(formationId);
    }
}
