package com.isi.formation.services;

import com.isi.formation.domain.Formation;
import com.isi.formation.mappers.FormationMapper;
import com.isi.formation.repository.FormationRepository;
import com.isi.formation.web.models.FormationDto;
import com.isi.formation.web.models.FormationDto;
import lombok.RequiredArgsConstructor;
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

    @Override
    public URI saveFormation(FormationDto formationDto) {
        Formation formation = formationRepository.save(formationMapper.formationDtoToFormation(formationDto));

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(formation.getId()).toUri();
    }

    @Override
    public void updateFormation(FormationDto formationDto) {
        Formation savedFormation = formationRepository.findById(formationDto.getId()).orElseThrow(RuntimeException::new);

        savedFormation.setDuree(formationDto.getDuree());
        savedFormation.setBudget(formationDto.getBudget());
        savedFormation.setTitre(formationDto.getTitre());

        formationRepository.save(savedFormation);

    }

    @Override
    public List<FormationDto> getAllFormation() {
        return formationRepository.findAll()
                .stream()
                .map(formationMapper::formationToFormationDto)
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
