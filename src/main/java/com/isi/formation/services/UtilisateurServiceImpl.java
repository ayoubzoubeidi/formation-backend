package com.isi.formation.services;

import com.isi.formation.domain.Utilisateur;
import com.isi.formation.mappers.UtilisateurMapper;
import com.isi.formation.repository.UtilisateurRepository;
import com.isi.formation.web.models.UtilisateurDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    @Override
    public URI saveUtilisateur(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurRepository.save(utilisateurMapper.utilisateurDtoToUtilisateur(utilisateurDto));

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(utilisateur.getId()).toUri();
    }

    @Override
    public void updateUtilisateur(UtilisateurDto utilisateurDto, UUID id) {
        Utilisateur savedUtilisateur = utilisateurRepository.findById(id).orElseThrow(RuntimeException::new);

        savedUtilisateur.setLogin(utilisateurDto.getLogin());
        savedUtilisateur.setPassword(utilisateurDto.getPassword());

        utilisateurRepository.save(savedUtilisateur);

    }

    @Override
    public List<UtilisateurDto> getAllUtilisateur() {
        return utilisateurRepository.findAll()
                .stream()
                .map(utilisateurMapper::utilisateurToUtilisateurDto)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDto getUtilisateurById(UUID utilisateurId) {
        Utilisateur savedUtilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow(RuntimeException::new);
        return utilisateurMapper.utilisateurToUtilisateurDto(savedUtilisateur);
    }

    @Override
    public void deleteUtilisateurById(UUID utilisateurId) {
        utilisateurRepository.deleteById(utilisateurId);
    }
}
