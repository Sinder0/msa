package com.sindero.DnD.repository;

import com.sindero.DnD.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpellRepository extends JpaRepository<Spell, Long> {
    Optional<Spell> findByName(String name);
}
