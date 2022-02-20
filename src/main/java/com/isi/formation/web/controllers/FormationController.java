package com.isi.formation.web.controllers;

import com.isi.formation.services.FormationService;
import com.isi.formation.web.models.FormationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.isi.formation.web.controllers.ApiUrls.*;

@Controller
@RequestMapping(FORMATION_MAIN_URL)
@RequiredArgsConstructor
public class FormationController {

    private final FormationService FormationService;

    @GetMapping
    public ResponseEntity<?> getAllFormation() {
        return new ResponseEntity<>(FormationService.getAllFormation(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveFormation(@RequestBody FormationDto FormationDto) {
        return ResponseEntity.created(FormationService.saveFormation(FormationDto)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFormationById(@PathVariable UUID id) {
        return new ResponseEntity<>(FormationService.getFormationById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFormationById(@RequestBody FormationDto FormationDto) {
        FormationService.updateFormation(FormationDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFormationById(@PathVariable UUID id) {
        FormationService.deleteFormationById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
