package com.isi.formation.mappers;

import com.isi.formation.domain.Participant;
import com.isi.formation.web.models.ParticipantDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, PaysMapper.class, SessionMapper.class})
public interface ParticipantMapper {

    Participant participantDtoToParticipant(ParticipantDto participantDto);

    ParticipantDto participantToParticipantDto(Participant participant);

}
