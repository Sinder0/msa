package com.sindero.DnD.repository;

import com.sindero.DnD.model.Character;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CharacterRepositoryTest {

    @Autowired
    private CharacterRepository characterRepository;

    @Test
    void saveCharacter_shouldPersistAndReturnCharacter() {
        Character character = new Character();
        character.setName("Gandalf");
        Character savedCharacter = characterRepository.save(character);
        assertNotNull(savedCharacter.getId());
        assertEquals("Gandalf", savedCharacter.getName());
    }

    @Test
    void findByName_shouldReturnCharacterIfExists() {
        Character character = new Character();
        character.setName("Frodo");
        characterRepository.save(character);
        Optional<Character> foundCharacter = characterRepository.findByName("Frodo");
        assertTrue(foundCharacter.isPresent());
        assertEquals("Frodo", foundCharacter.get().getName());
    }
}
