package com.pinsoft.intern.controller;

import com.pinsoft.intern.entity.User;
import com.pinsoft.intern.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> get() {
        return  userService.getALl();
    }
}
