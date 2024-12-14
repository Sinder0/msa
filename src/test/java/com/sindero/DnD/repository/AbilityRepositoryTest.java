package com.sindero.DnD.repository;

import com.sindero.DnD.model.Ability;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AbilityRepositoryTest {

    @Autowired
    private AbilityRepository abilityRepository;

    @Test
    void saveAbility_shouldPersistAndReturnAbility() {
        Ability ability = new Ability();
        ability.setName("Strength");
        Ability savedAbility = abilityRepository.save(ability);
        assertNotNull(savedAbility.getId());
        assertEquals("Strength", savedAbility.getName());
    }

    @Test
    void findByName_shouldReturnAbilityIfExists() {
        Ability ability = new Ability();
        ability.setName("Dexterity");
        abilityRepository.save(ability);
        Optional<Ability> foundAbility = abilityRepository.findByName("Dexterity");
        assertTrue(foundAbility.isPresent());
        assertEquals("Dexterity", foundAbility.get().getName());
    }

    @Test
    void findByName_shouldReturnEmptyIfNotExists() {
        Optional<Ability> foundAbility = abilityRepository.findByName("NonExistent");
        assertFalse(foundAbility.isPresent());
    }
}