package com.isi.formation.services;

import com.isi.formation.domain.Domaine;
import com.isi.formation.mappers.DomaineMapper;
import com.isi.formation.repository.DomaineRepository;
import com.isi.formation.web.models.DomaineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DomaineServiceImpl implements DomaineService {

    private final DomaineRepository domaineRepository;
    private final DomaineMapper domaineMapper;

    @Override
    public URI saveDomaine(DomaineDto domaineDto) {
        Domaine domaine = domaineRepository.save(domaineMapper.domaineDtoToDomaine(domaineDto));

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(domaine.getId()).toUri();
    }

    @Override
    public void updateDomaine(DomaineDto domaineDto) {
        Domaine savedDomaine = domaineRepository.findById(domaineDto.getId()).orElseThrow(RuntimeException::new);

        savedDomaine.setLibelle(domaineDto.getLibelle());

        domaineRepository.save(savedDomaine);

    }

    @Override
    public List<DomaineDto> getAllDomaine() {
        return domaineRepository.findAll()
                .stream()
                .map(domaineMapper::domaineToDomaineDto)
                .collect(Collectors.toList());
    }

    @Override
    public DomaineDto getDomaineById(UUID domaineId) {
        Domaine savedDomaine = domaineRepository.findById(domaineId).orElseThrow(RuntimeException::new);
        return domaineMapper.domaineToDomaineDto(savedDomaine);
    }

    @Override
    public void deleteDomaineById(UUID domaineId) {
        domaineRepository.deleteById(domaineId);
    }
}
