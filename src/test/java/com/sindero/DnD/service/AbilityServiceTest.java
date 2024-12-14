package com.sindero.DnD.service;

import com.sindero.DnD.model.Ability;
import com.sindero.DnD.repository.AbilityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AbilityServiceTest {

    @InjectMocks
    private AbilityService abilityService;

    @Mock
    private AbilityRepository abilityRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByName_shouldReturnAbility_whenAbilityExists() {
        Ability ability = new Ability();
        ability.setName("Strength");
        when(abilityRepository.findByName("Strength")).thenReturn(Optional.of(ability));
        Ability result = abilityService.findByName("Strength");
        assertNotNull(result);
        assertEquals("Strength", result.getName());
    }

    @Test
    void findByName_shouldReturnNull_whenAbilityDoesNotExist() {
        when(abilityRepository.findByName("NonExistent")).thenReturn(Optional.empty());
        Ability result = abilityService.findByName("NonExistent");
        assertNull(result);
    }

    @Test
    void save_shouldPersistAndReturnAbility() {
        Ability ability = new Ability();
        ability.setName("Dexterity");
        when(abilityRepository.save(ability)).thenReturn(ability);
        Ability result = abilityService.save(ability);
        assertNotNull(result);
        assertEquals("Dexterity", result.getName());
        verify(abilityRepository, times(1)).save(ability);
    }

    @Test
    void deleteById_shouldCallRepositoryDelete() {
        Long abilityId = 1L;
        abilityService.deleteById(abilityId);
        verify(abilityRepository, times(1)).deleteById(abilityId);
    }
}
