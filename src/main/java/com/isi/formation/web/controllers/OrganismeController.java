package com.isi.formation.web.controllers;

import com.isi.formation.services.OrganismeService;
import com.isi.formation.web.models.OrganismeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.isi.formation.web.controllers.ApiUrls.ORGANISME_MAIN_URL;

@Controller
@RequestMapping(ORGANISME_MAIN_URL)
@RequiredArgsConstructor
public class OrganismeController {

    private final OrganismeService OrganismeService;

    @GetMapping
    public ResponseEntity<?> getAllOrganisme() {
        return new ResponseEntity<>(OrganismeService.getAllOrganisme(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveOrganisme(@RequestBody OrganismeDto OrganismeDto) {
        return ResponseEntity.created(OrganismeService.saveOrganisme(OrganismeDto)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrganismeById(@PathVariable UUID id) {
        return new ResponseEntity<>(OrganismeService.getOrganismeById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrganismeById(@RequestBody OrganismeDto OrganismeDto, @PathVariable UUID id) {
        OrganismeService.updateOrganisme(OrganismeDto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrganismeById(@PathVariable UUID id) {
        OrganismeService.deleteOrganismeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
