package com.isi.formation.mappers;

import com.isi.formation.domain.Formation;
import com.isi.formation.web.models.FormationDto;
import org.mapstruct.Mapper;

@Mapper(uses = {ParticipantMapper.class, SessionMapper.class})
public interface FormationMapper {

    Formation formationDtoToFormation(FormationDto formationDto);

    FormationDto formationToFormationDto(Formation formation);

}
