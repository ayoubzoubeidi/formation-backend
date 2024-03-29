package com.isi.formation.repository;

import com.isi.formation.domain.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {


    Optional<ApplicationUser> findByUsername(String username);
    Boolean existsByUsername(String username);

}
