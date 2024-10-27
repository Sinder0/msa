package com.sindero.DnD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int level;

    private int HP;
    private int MP;

    private int strength;
    private int dexterity;
    private int intelligence;

    @ManyToOne
    private Archetype archetype;

    public Character orElse(Object o) {
        return null;
    }
}
