package com.isi.formation.web.controllers;

import com.isi.formation.services.DomaineService;
import com.isi.formation.web.models.DomaineDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.UUID;

import static com.isi.formation.web.controllers.ApiUrls.DOMAINE_MAIN_URL;

@Controller
@RequestMapping(DOMAINE_MAIN_URL)
@RequiredArgsConstructor
public class DomaineController {

    private final DomaineService domaineService;

    @PreAuthorize("hasAuthority('read.all')")
    @GetMapping
    public ResponseEntity<?> getAllDomaine() {
        return new ResponseEntity<>(domaineService.getAllDomaine(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('read.all')")
    @PostMapping
    public ResponseEntity<?> saveDomaine(@RequestBody DomaineDto domaineDto) {
        return ResponseEntity.created(domaineService.saveDomaine(domaineDto)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDomaineById(@PathVariable UUID id) {
        return new ResponseEntity<>(domaineService.getDomaineById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDomaineById(@RequestBody DomaineDto domaineDto, @PathVariable UUID id) {
        domaineService.updateDomaine(domaineDto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDomaineById(@PathVariable UUID id) {
        domaineService.deleteDomaineById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
