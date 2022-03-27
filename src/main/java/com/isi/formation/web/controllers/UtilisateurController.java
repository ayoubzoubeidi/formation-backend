package com.isi.formation.web.controllers;

import com.isi.formation.services.UtilisateurService;
import com.isi.formation.web.models.UtilisateurDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.isi.formation.web.controllers.ApiUrls.UTILISATEUR_MAIN_URL;

@Controller
@RequestMapping(UTILISATEUR_MAIN_URL)
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService UtilisateurService;

    @GetMapping
    public ResponseEntity<?> getAllUtilisateur() {
        return new ResponseEntity<>(UtilisateurService.getAllUtilisateur(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveUtilisateur(@RequestBody UtilisateurDto UtilisateurDto) {
        return ResponseEntity.created(UtilisateurService.saveUtilisateur(UtilisateurDto)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUtilisateurById(@PathVariable UUID id) {
        return new ResponseEntity<>(UtilisateurService.getUtilisateurById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUtilisateurById(@RequestBody UtilisateurDto UtilisateurDto, @PathVariable UUID id) {
        UtilisateurService.updateUtilisateur(UtilisateurDto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUtilisateurById(@PathVariable UUID id) {
        UtilisateurService.deleteUtilisateurById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
