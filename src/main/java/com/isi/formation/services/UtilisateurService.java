package com.isi.formation.services;

import com.isi.formation.web.models.UtilisateurDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface UtilisateurService {

    URI saveUtilisateur(UtilisateurDto UtilisateurDto);

    void updateUtilisateur(UtilisateurDto UtilisateurDto, UUID id);

    List<UtilisateurDto> getAllUtilisateur();

    UtilisateurDto getUtilisateurById(UUID UtilisateurId);

    void deleteUtilisateurById(UUID UtilisateurId);
    
}
