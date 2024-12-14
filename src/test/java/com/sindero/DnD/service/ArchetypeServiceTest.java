package com.sindero.DnD.service;

import com.sindero.DnD.model.Archetype;
import com.sindero.DnD.repository.ArchetypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ArchetypeServiceTest {

    @InjectMocks
    private ArchetypeService archetypeService;

    @Mock
    private ArchetypeRepository archetypeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll_shouldReturnListOfArchetypes() {
        Archetype archetype1 = new Archetype();
        archetype1.setName("Wizard");
        Archetype archetype2 = new Archetype();
        archetype2.setName("Warrior");
        when(archetypeRepository.findAll()).thenReturn(List.of(archetype1, archetype2));
        List<Archetype> result = archetypeService.findAll();
        assertEquals(2, result.size());
        verify(archetypeRepository, times(1)).findAll();
    }

    @Test
    void save_shouldPersistAndReturnArchetype() {
        Archetype archetype = new Archetype();
        archetype.setName("Rogue");
        when(archetypeRepository.save(archetype)).thenReturn(archetype);
        Archetype result = archetypeService.save(archetype);
        assertNotNull(result);
        assertEquals("Rogue", result.getName());
        verify(archetypeRepository, times(1)).save(archetype);
    }
}
