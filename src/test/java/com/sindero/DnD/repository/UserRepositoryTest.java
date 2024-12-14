package com.sindero.DnD.repository;

import com.sindero.DnD.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser_shouldPersistAndReturnUser() {
        User user = new User();
        user.setUsername("test_user");
        user.setPassword("password123");
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getId());
        assertEquals("test_user", savedUser.getUsername());
    }

    @Test
    void findByUsername_shouldReturnUserIfExists() {
        User user = new User();
        user.setUsername("admin");
        userRepository.save(user);
        Optional<User> foundUser = userRepository.findByUsername("admin");
        assertTrue(foundUser.isPresent());
        assertEquals("admin", foundUser.get().getUsername());
    }
}
