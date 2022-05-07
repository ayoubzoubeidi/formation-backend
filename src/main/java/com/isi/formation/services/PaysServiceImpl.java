package com.isi.formation.services;

import com.isi.formation.domain.Pays;
import com.isi.formation.mappers.PaysMapper;
import com.isi.formation.repository.PaysRepository;
import com.isi.formation.web.models.PaysDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaysServiceImpl implements PaysService {

    private final PaysRepository paysRepository;
    private final PaysMapper paysMapper;
    
    @Override
    public URI savePays(PaysDto paysDto) {
        Pays pays = paysRepository.save(paysMapper.paysDtoToPays(paysDto));

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(pays.getId()).toUri();
    }

    @Override
    public void updatePays(PaysDto paysDto, UUID id) {
        Pays savedPays = paysRepository.findById(id).orElseThrow(RuntimeException::new);

        savedPays.setNom(paysDto.getNom());

        paysRepository.save(savedPays);

    }

    @Override
    @Cacheable("pays")
    public List<PaysDto> getAllPays() {
        return paysRepository.findAll()
                .stream()
                .map(paysMapper::paysToPaysDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaysDto getPaysById(UUID paysId) {
        Pays savedPays = paysRepository.findById(paysId).orElseThrow(RuntimeException::new);
        return paysMapper.paysToPaysDto(savedPays);
    }

    @Override
    public void deletePaysById(UUID paysId) {
        paysRepository.deleteById(paysId);
    }
}
