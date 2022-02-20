package com.isi.formation.mappers;

import com.isi.formation.domain.Utilisateur;
import com.isi.formation.web.models.UtilisateurDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface UtilisateurMapper {

    Utilisateur utilisateurDtoToUtilisateur(UtilisateurDto utilisateurDto);

    UtilisateurDto utilisateurToUtilisateurDto(Utilisateur utilisateur);

}
