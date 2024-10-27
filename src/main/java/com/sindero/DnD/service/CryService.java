package com.sindero.DnD.service;

import com.sindero.DnD.model.Cry;
import com.sindero.DnD.repository.CryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CryService {
    private final CryRepository cryRepository;

    public List<Cry> findAll() {
        return cryRepository.findAll();
    }
}
