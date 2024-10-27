package com.sindero.DnD.controller;

import com.sindero.DnD.model.Cry;
import com.sindero.DnD.service.CryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cries")
public class CryController {

    private final CryService cryService;

    @PostMapping("/getAll")
    public ResponseEntity<List<Cry>> getAll() {
        return new ResponseEntity<>(cryService.findAll(), HttpStatus.OK);
    }
}
