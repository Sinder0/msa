package com.sindero.DnD.repository;

import com.sindero.DnD.model.Archetype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArchetypeRepository extends JpaRepository<Archetype, Long> {
    Optional<Archetype> findByName(String name);
}
