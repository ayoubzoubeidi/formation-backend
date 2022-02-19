package com.isi.formation.repository;

import com.isi.formation.domain.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DomaineRepository extends JpaRepository<Domaine, UUID> {
}
