package com.pinsoft.intern.service;

import com.pinsoft.intern.dto.LoginRequest;
import com.pinsoft.intern.dto.RegisterRequest;
import com.pinsoft.intern.entity.User;
import com.pinsoft.intern.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<User> findUser(LoginRequest userRequest) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(userRequest.getEmail()).orElse(null));
        if (user.isPresent()) {
            if (user.get().getPassword().equals(userRequest.getPassword())) {
                return ResponseEntity.ok(user.get());
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
