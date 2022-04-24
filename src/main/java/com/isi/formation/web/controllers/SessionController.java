package com.isi.formation.web.controllers;


import com.isi.formation.services.SessionService;
import com.isi.formation.web.models.SessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.isi.formation.web.controllers.ApiUrls.SESSION_MAIN_URL;

@Controller
@RequestMapping(SESSION_MAIN_URL)
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping
    public ResponseEntity<?> getAllSession() {
        return new ResponseEntity<>(sessionService.getAllSession(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveSession(@RequestBody SessionDto SessionDto) {
        return ResponseEntity.created(sessionService.saveSession(SessionDto)).build();
    }

    @GetMapping("/{sessionsId}/participants")
    public ResponseEntity<?> getParticipation(@PathVariable UUID sessionsId) {
        return new ResponseEntity<>(sessionService.getParticipationBySessionId(sessionsId), HttpStatus.OK);
    }

    @GetMapping("/{sessionsId}/not-participants")
    public ResponseEntity<?> getNotParticipants(@PathVariable UUID sessionsId) {
        return new ResponseEntity<>(sessionService.getParticipationNotInSession(sessionsId), HttpStatus.OK);
    }

    @PostMapping("/{sessionsId}/subscribe/{participantId}")
    public ResponseEntity<?> subscribeSession(@PathVariable UUID sessionsId, @PathVariable UUID participantId) {
        sessionService.subscribeToSession(sessionsId, participantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{sessionsId}/unsubscribe/{participantId}")
    public ResponseEntity<?> unsubscribeSession(@PathVariable UUID sessionsId, @PathVariable UUID participantId) {
        sessionService.unsubscribeToSession(sessionsId, participantId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSessionById(@PathVariable UUID id) {
        return new ResponseEntity<>(sessionService.getSessionById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSessionById(@RequestBody SessionDto SessionDto, @PathVariable UUID id) {
        sessionService.updateSession(SessionDto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSessionById(@PathVariable UUID id) {
        sessionService.deleteSessionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
