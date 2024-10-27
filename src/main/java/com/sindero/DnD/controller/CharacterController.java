package com.sindero.DnD.controller;

import com.sindero.DnD.model.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sindero.DnD.service.CharacterService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    @RequestMapping("/create")
    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        return ResponseEntity.status(HttpStatus.CREATED).body(characterService.createCharacter(character));
    }

    @RequestMapping("/get")
    @PostMapping
    public ResponseEntity<Character> getCharacter(@RequestBody Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(characterService.getCharacter(id));
    }

    @RequestMapping("/delete")
    @PostMapping
    public ResponseEntity<Character> deleteCharacter(@RequestBody Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping("/update")
    @PostMapping
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character) {
        return ResponseEntity.status(HttpStatus.OK).body(characterService.updateCharacter(character));
    }

    @RequestMapping("/getAll")
    @PostMapping
    public ResponseEntity<Iterable<Character>> getCharacters() {
        return ResponseEntity.status(HttpStatus.OK).body(characterService.getCharacters());
    }
}
