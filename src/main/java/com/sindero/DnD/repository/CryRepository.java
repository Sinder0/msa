package com.sindero.DnD.repository;

import com.sindero.DnD.model.Cry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CryRepository extends JpaRepository<Cry, Long> {

    Optional<Cry> findByName(String name);
}
