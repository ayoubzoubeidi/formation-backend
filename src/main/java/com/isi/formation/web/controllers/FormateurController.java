package com.isi.formation.web.controllers;

import com.isi.formation.services.FormateurService;
import com.isi.formation.web.models.FormateurDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.isi.formation.web.controllers.ApiUrls.FORMATEUR_MAIN_URL;

@Controller
@RequestMapping(FORMATEUR_MAIN_URL)
@RequiredArgsConstructor
public class FormateurController {

    private final FormateurService FormateurService;

    @GetMapping
    public ResponseEntity<?> getAllFormateur() {
        return new ResponseEntity<>(FormateurService.getAllFormateur(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveFormateur(@RequestBody FormateurDto FormateurDto) {
        return ResponseEntity.created(FormateurService.saveFormateur(FormateurDto)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFormateurById(@PathVariable UUID id) {
        return new ResponseEntity<>(FormateurService.getFormateurById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFormateurById(@RequestBody FormateurDto FormateurDto, @PathVariable UUID id) {
        FormateurService.updateFormateur(FormateurDto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFormateurById(@PathVariable UUID id) {
        FormateurService.deleteFormateurById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
