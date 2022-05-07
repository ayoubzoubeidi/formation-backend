package com.isi.formation.repository;

import com.isi.formation.domain.ApplicationUser;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {


    @Query("FROM ApplicationUser a, Role r JOIN FETCH a.roles JOIN FETCH r.authorities")
    Optional<ApplicationUser> findByUsername(String username);

}
