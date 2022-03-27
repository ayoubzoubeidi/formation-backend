package com.isi.formation.services;

import com.isi.formation.domain.Session;
import com.isi.formation.mappers.SessionMapper;
import com.isi.formation.repository.SessionRepository;
import com.isi.formation.web.models.SessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    @Override
    public URI saveSession(SessionDto sessionDto) {
        Session session = sessionRepository.save(sessionMapper.sessionDtoToSession(sessionDto));

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(session.getId()).toUri();
    }

    @Override
    public void updateSession(SessionDto sessionDto, UUID id) {
        Session savedSession = sessionRepository.findById(id).orElseThrow(RuntimeException::new);

        savedSession.setDateDebut(sessionDto.getDateDebut());
        savedSession.setDateFin(sessionDto.getDateFin());

        sessionRepository.save(savedSession);

    }

    @Override
    public List<SessionDto> getAllSession() {
        return sessionRepository.findAll()
                .stream()
                .map(sessionMapper::sessionToSessionDto)
                .collect(Collectors.toList());
    }

    @Override
    public SessionDto getSessionById(UUID sessionId) {
        Session savedSession = sessionRepository.findById(sessionId).orElseThrow(RuntimeException::new);
        return sessionMapper.sessionToSessionDto(savedSession);
    }

    @Override
    public void deleteSessionById(UUID sessionId) {
        sessionRepository.deleteById(sessionId);
    }
}
