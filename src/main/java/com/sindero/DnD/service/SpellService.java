package com.sindero.DnD.service;

import com.sindero.DnD.model.Spell;
import com.sindero.DnD.repository.SpellRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpellService {
    private final SpellRepository spellRepository;

    public List<Spell> findAll() {
        return spellRepository.findAll();
    }
}
