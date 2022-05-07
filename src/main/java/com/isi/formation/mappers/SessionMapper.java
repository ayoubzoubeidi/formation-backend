package com.isi.formation.mappers;

import com.isi.formation.domain.Session;
import com.isi.formation.mappers.annotation.DoIgnore;
import com.isi.formation.web.models.SessionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class})
public interface SessionMapper {

    @Mapping(source = "formation", target = "formation", ignore = true)
    Session sessionDtoToSession(SessionDto sessionDto);

    @Mapping(source = "formation", target = "formation", ignore = true)
    @Mapping(source = "participants", target = "participants", ignore = true)
    @DoIgnore
    Session sessionDtoToSessionWithoutParticipant(SessionDto sessionDto);

    @Mapping(source = "formation.titre", target = "formation")
    @Mapping(target = "participants", ignore = true)
    SessionDto sessionToSessionDto(Session session);

}
