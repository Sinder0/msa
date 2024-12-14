package com.sindero.DnD.service;

import com.sindero.DnD.model.Ability;
import com.sindero.DnD.repository.AbilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbilityService {
    private final AbilityRepository abilityRepository;

    public List<Ability> findAll() {
        return abilityRepository.findAll();
    }

    public Ability findByName(String name) {
        return abilityRepository.findByName(name).orElse(null);
    }

    public Ability findById(final Long id) {
        return abilityRepository.findById(id).orElse(null);
    }

    public Ability save(Ability ability) {
        return abilityRepository.save(ability);
    }

    public void deleteById(final Long id) {
        abilityRepository.deleteById(id);
    }
}

