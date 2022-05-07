package com.isi.formation.repository;

import com.isi.formation.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ParticipantRepository extends JpaRepository<Participant, UUID> {

    @Query("select p from Participant p where p.nom = ?1")
    Optional<Participant> findByNom(String nom);

}
