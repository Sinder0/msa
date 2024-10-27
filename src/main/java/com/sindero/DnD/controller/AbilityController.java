package com.sindero.DnD.controller;

import com.sindero.DnD.model.Ability;
import com.sindero.DnD.service.AbilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/abilities")
public class AbilityController {

    private final AbilityService abilityService;

    @PostMapping("/getAll")
    public ResponseEntity<List<Ability>> getAll() {
        return new ResponseEntity<>(abilityService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Ability> add(@RequestBody Ability ability) {
        return new ResponseEntity<>(abilityService.save(ability), HttpStatus.CREATED);
    }
}
