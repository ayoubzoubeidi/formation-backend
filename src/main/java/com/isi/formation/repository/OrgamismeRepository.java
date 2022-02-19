package com.isi.formation.repository;

import com.isi.formation.domain.Organisme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrgamismeRepository extends JpaRepository<Organisme, UUID> {
}
