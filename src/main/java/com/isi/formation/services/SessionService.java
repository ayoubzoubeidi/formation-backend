package com.isi.formation.services;

import com.isi.formation.web.models.ParticipantDto;
import com.isi.formation.web.models.SessionDto;
import com.isi.formation.web.models.SessionListDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface SessionService {

    URI saveSession(SessionDto SessionDto);

    void updateSession(SessionDto SessionDto, UUID id);

    List<SessionListDto> getAllSession();

    List<ParticipantDto> getParticipationBySessionId(UUID sessionId);

    List<ParticipantDto> getParticipationNotInSession(UUID sessionId);

    SessionDto getSessionById(UUID SessionId);

    void deleteSessionById(UUID SessionId);

    void subscribeToSession(UUID sessionsId, UUID participantId);

    void unsubscribeToSession(UUID sessionsId, UUID participantId);
}
