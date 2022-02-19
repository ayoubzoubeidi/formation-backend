package com.isi.formation.repository;

import com.isi.formation.domain.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormateurRepository extends JpaRepository<Formateur, UUID> {
}
