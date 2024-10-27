package com.sindero.DnD.service;

import com.sindero.DnD.model.User;
import com.sindero.DnD.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return userRepository.findByUsername(username).orElseThrow(() ->
                    new UsernameNotFoundException("User not found with username: " + username));
        } catch (Exception e) {
            throw new RuntimeException("Error loading user by username", e);
        }
    }

    public void changePassword(String name, String password) {
        User user = userRepository.findByUsername(name).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + name));
        user.setPassword(password);
        userRepository.save(user);
    }

    public void changeRole(String username, String role) {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User not found with username: " + username));
        user.setRole(User.Role.valueOf(role));
        userRepository.save(user);
    }
}
