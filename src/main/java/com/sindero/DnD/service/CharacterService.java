package com.sindero.DnD.service;

import com.sindero.DnD.model.Character;
import com.sindero.DnD.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public Character createCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character getCharacter(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }

    public Character updateCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Iterable<Character> getCharacters() {
        return characterRepository.findAll();
    }
}