package com.pinsoft.intern.service;

import com.pinsoft.intern.dto.LoginRequest;
import com.pinsoft.intern.dto.RegisterRequest;
import com.pinsoft.intern.entity.User;
import com.pinsoft.intern.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository  userRepository;

    public List<User> getALl() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(RegisterRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setLastname(userRequest.getLastname());
        return userRepository.save(user);
    }

    public User findUser(LoginRequest userRequest) {
        User user =  userRepository.findByEmail(userRequest.getEmail());
        if(userRequest.getPassword().equals(user.getPassword())) {
           return user;
        }
        return null;
    }
}
