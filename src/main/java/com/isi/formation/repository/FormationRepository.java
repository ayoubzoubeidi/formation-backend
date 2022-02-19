package com.isi.formation.repository;

import com.isi.formation.domain.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormationRepository extends JpaRepository<Formation, UUID> {
}
