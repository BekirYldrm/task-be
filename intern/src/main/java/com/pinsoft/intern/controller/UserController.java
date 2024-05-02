package com.pinsoft.intern.controller;

import com.pinsoft.intern.dto.LoginRequest;
import com.pinsoft.intern.dto.RegisterRequest;
import com.pinsoft.intern.entity.User;
import com.pinsoft.intern.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> get() {
        return  userService.getALl();
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/register")
    public User addUser(@RequestBody RegisterRequest userRequest) {
        return userService.saveUser(userRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody LoginRequest userRequest) {
        return userService.findUser(userRequest);
    }
}
