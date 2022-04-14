package com.isi.formation.mappers;

import com.isi.formation.domain.Session;
import com.isi.formation.web.models.SessionDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, FormationMapper.class, ParticipantMapper.class})
public interface SessionMapper {

    Session sessionDtoToSession(SessionDto sessionDto);

    SessionDto sessionToSessionDto(Session session);

}
