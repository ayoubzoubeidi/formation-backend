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

    private final SessionService SessionService;

    @GetMapping
    public ResponseEntity<?> getAllSession() {
        return new ResponseEntity<>(SessionService.getAllSession(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveSession(@RequestBody SessionDto SessionDto) {
        return ResponseEntity.created(SessionService.saveSession(SessionDto)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSessionById(@PathVariable UUID id) {
        return new ResponseEntity<>(SessionService.getSessionById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSessionById(@RequestBody SessionDto SessionDto, @PathVariable UUID id) {
        SessionService.updateSession(SessionDto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSessionById(@PathVariable UUID id) {
        SessionService.deleteSessionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
