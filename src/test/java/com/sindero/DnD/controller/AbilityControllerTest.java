package com.sindero.DnD.controller;

import com.sindero.DnD.model.Ability;
import com.sindero.DnD.service.AbilityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AbilityController.class)
public class AbilityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AbilityService abilityService;

    @Test
    @WithMockUser
    void getAll_shouldReturnListOfAbilities() throws Exception {
        Ability ability1 = new Ability();
        ability1.setName("Strength");
        Ability ability2 = new Ability();
        ability2.setName("Dexterity");
        when(abilityService.findAll()).thenReturn(List.of(ability1, ability2));
        mockMvc.perform(get("/api/abilities/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Strength"))
                .andExpect(jsonPath("$[1].name").value("Dexterity"));

        verify(abilityService, times(1)).findAll();
    }
}
