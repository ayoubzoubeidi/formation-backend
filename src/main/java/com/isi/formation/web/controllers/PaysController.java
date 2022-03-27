package com.isi.formation.web.controllers;

import com.isi.formation.services.PaysService;
import com.isi.formation.web.models.PaysDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.isi.formation.web.controllers.ApiUrls.PAYS_MAIN_URL;

@Controller
@RequestMapping(PAYS_MAIN_URL)
@RequiredArgsConstructor
public class PaysController {

    private final PaysService PaysService;

    @GetMapping
    public ResponseEntity<?> getAllPays() {
        return new ResponseEntity<>(PaysService.getAllPays(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savePays(@RequestBody PaysDto PaysDto) {
        return ResponseEntity.created(PaysService.savePays(PaysDto)).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaysById(@PathVariable UUID id) {
        return new ResponseEntity<>(PaysService.getPaysById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePaysById(@RequestBody PaysDto PaysDto, @PathVariable UUID id) {
        PaysService.updatePays(PaysDto, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePaysById(@PathVariable UUID id) {
        PaysService.deletePaysById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
