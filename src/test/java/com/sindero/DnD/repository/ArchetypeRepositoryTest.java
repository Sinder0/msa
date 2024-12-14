package com.sindero.DnD.repository;

import com.sindero.DnD.model.Archetype;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ArchetypeRepositoryTest {

    @Autowired
    private ArchetypeRepository archetypeRepository;

    @Test
    void saveArchetype_shouldPersistAndReturnArchetype() {
        Archetype archetype = new Archetype();
        archetype.setName("Wizard");
        Archetype savedArchetype = archetypeRepository.save(archetype);
        assertNotNull(savedArchetype.getId());
        assertEquals("Wizard", savedArchetype.getName());
    }

    @Test
    void findByName_shouldReturnArchetypeIfExists() {
        Archetype archetype = new Archetype();
        archetype.setName("Warrior");
        archetypeRepository.save(archetype);
        Optional<Archetype> foundArchetype = archetypeRepository.findByName("Warrior");
        assertTrue(foundArchetype.isPresent());
        assertEquals("Warrior", foundArchetype.get().getName());
    }
}
