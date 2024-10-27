package com.sindero.DnD.service;

import com.sindero.DnD.model.Archetype;
import com.sindero.DnD.repository.ArchetypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ArchetypeService {
    private final ArchetypeRepository archetypeRepository;

    public List<Archetype> findAll() {
        return archetypeRepository.findAll();
    }

    public Archetype save(Archetype archetype) {
        return archetypeRepository.save(archetype);
    }
}
