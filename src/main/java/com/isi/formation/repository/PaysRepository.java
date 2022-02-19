package com.isi.formation.repository;

import com.isi.formation.domain.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaysRepository extends JpaRepository<Pays, UUID> {
}
