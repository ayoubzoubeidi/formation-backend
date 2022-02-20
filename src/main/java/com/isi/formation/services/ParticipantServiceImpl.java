package com.isi.formation.services;

import com.isi.formation.domain.Participant;
import com.isi.formation.domain.TypeParticipant;
import com.isi.formation.mappers.ParticipantMapper;
import com.isi.formation.repository.ParticipantRepository;
import com.isi.formation.web.models.ParticipantDto;
import com.isi.formation.web.models.ParticipantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;

    @Override
    public URI saveParticipant(ParticipantDto participantDto) {
        Participant Participant = participantRepository.save(participantMapper.participantDtoToParticipant(participantDto));

        return ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(Participant.getId()).toUri();
    }

    @Override
    public void updateParticipant(ParticipantDto participantDto) {
        Participant savedParticipant = participantRepository.findById(participantDto.getId()).orElseThrow(RuntimeException::new);

        savedParticipant.setTypeParticipant(TypeParticipant.valueOf(participantDto.getTypeParticipant()));
        savedParticipant.setEmail(participantDto.getEmail());
        savedParticipant.setNom(participantDto.getNom());
        savedParticipant.setPrenom(participantDto.getPrenom());
        savedParticipant.setTel(participantDto.getTel());

        participantRepository.save(savedParticipant);

    }

    @Override
    public List<ParticipantDto> getAllParticipant() {
        return participantRepository.findAll()
                .stream()
                .map(participantMapper::participantToParticipantDto)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipantDto getParticipantById(UUID ParticipantId) {
        Participant savedParticipant = participantRepository.findById(ParticipantId).orElseThrow(RuntimeException::new);
        return participantMapper.participantToParticipantDto(savedParticipant);
    }

    @Override
    public void deleteParticipantById(UUID ParticipantId) {
        participantRepository.deleteById(ParticipantId);
    }
}
