package com.isi.formation.services;

import com.isi.formation.domain.Formateur;
import com.isi.formation.domain.TypeFormateur;
import com.isi.formation.mappers.FormateurMapper;
import com.isi.formation.repository.FormateurRepository;
import com.isi.formation.web.models.FormateurDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FormateurServiceImpl implements FormateurService {

    private final FormateurRepository formateurRepository;
    private final FormateurMapper formateurMapper;

    @Override
    public URI saveFormateur(FormateurDto formateurDto) {
        Formateur Formateur = formateurRepository.save(formateurMapper.formateurDtoToFormateur(formateurDto));

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(Formateur.getId()).toUri();
    }

    @Override
    public void updateFormateur(FormateurDto formateurDto, UUID id) {

        Formateur savedFormateur = formateurRepository.findById(id).orElseThrow(RuntimeException::new);

        savedFormateur.setTypeFormateur(TypeFormateur.valueOf(formateurDto.getTypeFormateur()));
        savedFormateur.setEmail(formateurDto.getEmail());
        savedFormateur.setNom(formateurDto.getNom());
        savedFormateur.setPrenom(formateurDto.getPrenom());
        savedFormateur.setTel(formateurDto.getTel());

        formateurRepository.save(savedFormateur);

    }

    @Override
    public List<FormateurDto> getAllFormateur() {
        return formateurRepository.findAll()
                .stream()
                .map(formateurMapper::formateurToFormateurDto)
                .collect(Collectors.toList());
    }

    @Override
    public FormateurDto getFormateurById(UUID FormateurId) {
        Formateur savedFormateur = formateurRepository.findById(FormateurId).orElseThrow(RuntimeException::new);
        return formateurMapper.formateurToFormateurDto(savedFormateur);
    }

    @Override
    public void deleteFormateurById(UUID FormateurId) {
        formateurRepository.deleteById(FormateurId);
    }
}
