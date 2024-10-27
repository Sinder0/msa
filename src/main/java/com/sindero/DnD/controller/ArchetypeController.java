package com.sindero.DnD.controller;

import com.sindero.DnD.model.Archetype;
import com.sindero.DnD.service.ArchetypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/archetypes")
public class ArchetypeController {

    private final ArchetypeService archetypeService;

    @PostMapping("/getAll")
    public ResponseEntity<List<Archetype>> getAll() {
        return new ResponseEntity<>(archetypeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Archetype> add(Archetype archetype) {
        return new ResponseEntity<>(archetypeService.save(archetype), HttpStatus.CREATED);
    }
}
