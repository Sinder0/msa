package com.sindero.DnD.controller;

import com.sindero.DnD.model.Archetype;
import com.sindero.DnD.service.ArchetypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArchetypeController.class)
public class ArchetypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArchetypeService archetypeService;

    @Test
    @WithMockUser
    void add_shouldSaveArchetypeAndReturnCreatedStatus_withCsrf() throws Exception {
        Archetype archetype = new Archetype();
        archetype.setName("Warrior");

        when(archetypeService.save(any(Archetype.class))).thenReturn(archetype);

        mockMvc.perform(post("/api/archetypes/add")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Warrior\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Warrior"));

        verify(archetypeService, times(1)).save(any(Archetype.class));
    }

}
