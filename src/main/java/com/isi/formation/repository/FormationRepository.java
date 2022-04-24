package com.isi.formation.repository;

import com.isi.formation.domain.Formation;
import com.isi.formation.domain.Session;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FormationRepository extends JpaRepository<Formation, UUID> {

    @Query("FROM Session s " +
            "LEFT JOIN FETCH s.formation LEFT JOIN FETCH s.formateur " +
            "LEFT JOIN FETCH s.organisme LEFT JOIN FETCH s.participants LEFT JOIN FETCH s.formation.domaine" +
            " WHERE s.formation.id = :formationId ")
    List<Session> findAllSessionsByFormationId(@Param("formationId") UUID formationId);

}
