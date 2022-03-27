package com.isi.formation.services;

import com.isi.formation.web.models.SessionDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface SessionService {

    URI saveSession(SessionDto SessionDto);

    void updateSession(SessionDto SessionDto, UUID id);

    List<SessionDto> getAllSession();

    SessionDto getSessionById(UUID SessionId);

    void deleteSessionById(UUID SessionId);
}
