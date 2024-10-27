package com.sindero.DnD.controller;

import com.sindero.DnD.model.User;
import com.sindero.DnD.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User user_reg = userService.loadUserByUsername(user.getUsername());
        if (user_reg.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>(user_reg, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/changePassword")
    public ResponseEntity<User> changePassword(@RequestBody User user) {
        userService.changePassword(user.getUsername(), user.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/changeRole")
    public ResponseEntity<User> changeRole(@RequestBody User user) {
        userService.changeRole(user.getUsername(), user.getRole().toString());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<User> delete(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/getById")
    public ResponseEntity<User> getById(@RequestBody User user) {
        return new ResponseEntity<>(userService.getUserById(user.getId()), HttpStatus.OK);
    }

    @PostMapping("/getByUsername")
    public ResponseEntity<User> getByUsername(@RequestBody User user) {
        return new ResponseEntity<>(userService.loadUserByUsername(user.getUsername()), HttpStatus.OK);
    }
}

