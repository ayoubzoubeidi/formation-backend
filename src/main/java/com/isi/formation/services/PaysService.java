package com.isi.formation.services;

import com.isi.formation.web.models.PaysDto;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface PaysService {

    URI savePays(PaysDto PaysDto);

    void updatePays(PaysDto PaysDto, UUID id);

    List<PaysDto> getAllPays();

    PaysDto getPaysById(UUID PaysId);

    void deletePaysById(UUID PaysId);
}
