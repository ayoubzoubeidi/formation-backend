package com.isi.formation.web.controllers;

import com.isi.formation.services.ParticipantService;
import com.isi.formation.web.models.ParticipantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.isi.formation.web.controllers.ApiUrls.PARTICIPANT_MAIN_URL;

@Controller
@RequestMapping(PARTICIPANT_MAIN_URL)
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService ParticipantService;

    @GetMapping
    public ResponseEntity<?> getAllParticipant() {
        return new ResponseEntity<>(ParticipantService.getAllParticipant(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveParticipant(@RequestBody ParticipantDto ParticipantDto) {
        return ResponseEntity.created(ParticipantService.saveParticipant(ParticipantDto)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getParticipantById(@PathVariable UUID id) {
        return new ResponseEntity<>(ParticipantService.getParticipantById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateParticipantById(@RequestBody ParticipantDto ParticipantDto) {
        ParticipantService.updateParticipant(ParticipantDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParticipantById(@PathVariable UUID id) {
        ParticipantService.deleteParticipantById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
