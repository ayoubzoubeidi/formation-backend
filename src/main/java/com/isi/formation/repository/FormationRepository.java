package com.isi.formation.repository;

import com.isi.formation.domain.Formation;
import com.isi.formation.web.models.FormationMainList;
import com.isi.formation.web.models.SessionListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FormationRepository extends JpaRepository<Formation, UUID> {

    @Query("SELECT new com.isi.formation.web.models.SessionListDto(s.id, s.formation.titre, s.formateur.nom, s.dateDebut, s.dateFin)" +
            " FROM Session s" +
            " WHERE s.formation.id = :formationId ")
    List<SessionListDto> findAllSessionsByFormationId(@Param("formationId") UUID formationId);

    @Query("SELECT new com.isi.formation.web.models.FormationMainList(f.id, f.titre, f.domaine.libelle) FROM Formation f")
    List<FormationMainList> findAllFormationList();

    Formation getFormationByTitreLikeIgnoreCase(String titre);

}
