package com.sindero.DnD.service;

import com.sindero.DnD.model.Character;
import com.sindero.DnD.repository.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CharacterServiceTest {

    @InjectMocks
    private CharacterService characterService;

    @Mock
    private CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCharacter_shouldPersistAndReturnCharacter() {
        Character character = new Character();
        character.setName("Gandalf");
        when(characterRepository.save(character)).thenReturn(character);
        Character result = characterService.createCharacter(character);
        assertNotNull(result);
        assertEquals("Gandalf", result.getName());
        verify(characterRepository, times(1)).save(character);
    }

    @Test
    void getCharacter_shouldReturnCharacter_whenExists() {
        Long characterId = 1L;
        Character character = new Character();
        character.setName("Frodo");
        when(characterRepository.findById(characterId)).thenReturn(Optional.of(character));
        Character result = characterService.getCharacter(characterId);
        assertNotNull(result);
        assertEquals("Frodo", result.getName());
    }

    @Test
    void deleteCharacter_shouldCallRepositoryDelete() {
        Long characterId = 1L;
        characterService.deleteCharacter(characterId);
        verify(characterRepository, times(1)).deleteById(characterId);
    }
}
