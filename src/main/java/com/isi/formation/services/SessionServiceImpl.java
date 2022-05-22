package com.isi.formation.services;

import com.isi.formation.domain.Formateur;
import com.isi.formation.domain.Formation;
import com.isi.formation.domain.Session;
import com.isi.formation.mappers.ParticipantMapper;
import com.isi.formation.mappers.SessionMapper;
import com.isi.formation.repository.FormateurRepository;
import com.isi.formation.repository.FormationRepository;
import com.isi.formation.repository.ParticipantRepository;
import com.isi.formation.repository.SessionRepository;
import com.isi.formation.web.models.ParticipantDto;
import com.isi.formation.web.models.SessionDto;
import com.isi.formation.web.models.SessionListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final FormationRepository formationRepository;
    private final ParticipantRepository participantRepository;
    private final FormateurRepository formateurRepository;
    private final SessionMapper sessionMapper;
    private final ParticipantMapper participantMapper;

    @Override
    public URI saveSession(SessionDto sessionDto) {

        Session session = sessionMapper.sessionDtoToSessionWithoutParticipant(sessionDto);

        Formation formation = formationRepository.getFormationByTitreLikeIgnoreCase(sessionDto.getFormation());
        Formateur formateur = formateurRepository.getById(sessionDto.getFormateur().getId());

        session.setFormation(formation);
        session.setFormateur(formateur);

        for (ParticipantDto participant : sessionDto.getParticipants()) {

            var managedParticipant = participantRepository.getById(participant.getId());
            session.addParticipant(managedParticipant);

        }

        session = sessionRepository.save(session);

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
    public List<SessionListDto> getAllSession() {
        return sessionRepository.findSessionList();
    }

    @Override
    public List<ParticipantDto> getParticipationBySessionId(UUID sessionId) {
        return sessionRepository.findParticipantInSession(sessionId)
                .stream()
                .map(participantMapper::participantToParticipantDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParticipantDto> getParticipationNotInSession(UUID sessionId) {
        return sessionRepository.findParticipantNotInSession(sessionId)
                .stream()
                .map(participantMapper::participantToParticipantDto)
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

    @Override
    public void subscribeToSession(UUID sessionsId, UUID participantId) {
        sessionRepository.addParticipation(sessionsId, participantId);
    }

    @Override
    public void unsubscribeToSession(UUID sessionsId, UUID participantId) {
        sessionRepository.removeParticipation(sessionsId, participantId);
    }
}
