package com.sindero.DnD.controller;

import com.sindero.DnD.model.Spell;
import com.sindero.DnD.service.SpellService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/spells")
public class SpellController {

    private final SpellService spellService;

    @PostMapping("/getAll")
    public ResponseEntity<List<Spell>> getAll() {
        return new ResponseEntity<>(spellService.findAll(), HttpStatus.OK);
    }
}
