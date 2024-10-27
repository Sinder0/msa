package com.sindero.DnD;

import com.sindero.DnD.model.Ability;
import com.sindero.DnD.model.Archetype;
import com.sindero.DnD.model.Character;
import com.sindero.DnD.model.Cry;
import com.sindero.DnD.model.Spell;
import com.sindero.DnD.model.User;
import com.sindero.DnD.repository.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import java.util.Random;

@Service
@AllArgsConstructor
@Data
public class TestDataGenerator {


    private AbilityRepository abilityRepository;
    private ArchetypeRepository archetypeRepository;
    private CharacterRepository characterRepository;
    private CryRepository cryRepository;
    private SpellRepository spellRepository;
    private UserRepository userRepository;

    private static final String[] ABILITY_NAMES = {"Fireball", "Ice Blast", "Heal", "Lightning Bolt"};
    private static final String[] ARCHETYPE_NAMES = {"Mage", "Warrior", "Rogue"};
    private static final String[] CHARACTER_NAMES = {"Gandalf", "Frodo", "Legolas", "Aragorn"};
    private static final String[] CRY_NAMES = {"Scream", "Roar", "Whisper", "Yell"};
    private static final String[] SPELL_NAMES = {"Teleport", "Invisibility", "Shield", "Time Stop"};
    private static final String[] USERNAMES = {"admin", "user1", "user2"};

    private final Random random = new Random();

    @PostConstruct
    @Transactional
    public void generateTestData() {
        createAbilities();
        createArchetypes();
        createCharacters();
        createCries();
        createSpells();
        createUsers();
    }

    private void createAbilities() {
        for (String name : ABILITY_NAMES) {
            Ability ability = new Ability();
            ability.setName(name);
            ability.setDescription("Ability to " + name.toLowerCase());
            ability.setAbilityType(Ability.type.ACTIVE);
            abilityRepository.save(ability);
        }
    }

    private void createArchetypes() {
        for (String name : ARCHETYPE_NAMES) {
            Archetype archetype = new Archetype();
            archetype.setName(name);
            archetypeRepository.save(archetype);
        }
    }

    private void createCharacters() {
        for (String name : CHARACTER_NAMES) {
            Character character = new Character();
            character.setName(name);
            character.setDexterity(random.nextInt(20));
            character.setHP(random.nextInt(100) + 1);
            character.setIntelligence(random.nextInt(20));
            character.setLevel(random.nextInt(10) + 1);
            character.setMP(random.nextInt(50));
            character.setStrength(random.nextInt(20));
            characterRepository.save(character);
        }
    }

    private void createCries() {
        for (String name : CRY_NAMES) {
            Cry cry = new Cry();
            cry.setName(name);
            cry.setDescription(name + " cry");
            cry.setLevel(random.nextInt(5) + 1);
            cry.setManaCost(random.nextInt(10) + 1);
            cryRepository.save(cry);
        }
    }

    private void createSpells() {
        for (String name : SPELL_NAMES) {
            Spell spell = new Spell();
            spell.setName(name);
            spell.setDescription(name + " spell");
            spell.setLevel(random.nextInt(5) + 1);
            spell.setManaCost(random.nextInt(10) + 1);
            spellRepository.save(spell);
        }
    }

    private void createUsers() {
        for (String username : USERNAMES) {
            User user = new User();
            user.setUsername(username);
            user.setPassword("password123");
            user.setRole(User.Role.USER);
            userRepository.save(user);
        }
    }
}