package com.isi.formation.services;

import com.isi.formation.web.models.ParticipantDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface ParticipantService {

    URI saveParticipant(ParticipantDto ParticipantDto);

    void updateParticipant(ParticipantDto ParticipantDto);

    List<ParticipantDto> getAllParticipant();

    ParticipantDto getParticipantById(UUID ParticipantId);

    void deleteParticipantById(UUID ParticipantId);
    
}
