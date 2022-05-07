package com.isi.formation.repository;

import com.isi.formation.domain.Formateur;
import com.isi.formation.domain.Participant;
import com.isi.formation.domain.Session;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedAttributeNode;
import java.util.List;
import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {


    @EntityGraph(value = "Sessions.all")
    List<Session> findAll();

    @EntityGraph(value = "Participants.all")
    @Query("SELECT p FROM Participant p JOIN FETCH p.sessions s " +
            "WHERE s.id = :sessionId")
    List<Participant> findParticipantInSession(@Param("sessionId") UUID sessionId);

    @EntityGraph(value = "Participants.all")
    @Query("SELECT p FROM Participant p where p.id not in (" +
            " SELECT p2.id FROM Participant p2 JOIN p2.sessions s WHERE s.id = :sessionId)")
    List<Participant> findParticipantNotInSession(@Param("sessionId") UUID sessionId);

    @Query(value = "INSERT INTO participation VALUES(:sessionId, :participantId)", nativeQuery = true)
    @Modifying
    void addParticipation(@Param("sessionId") UUID sessionId, @Param("participantId") UUID participantId);

    @Query(value = "DELETE FROM participation " +
            "WHERE session_id = :sessionId AND participant_id = :participantId",
            nativeQuery = true)
    @Modifying
    void removeParticipation(@Param("sessionId") UUID sessionId, @Param("participantId") UUID participantId);


}
