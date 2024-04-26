package com.pinsoft.intern.service;

import com.pinsoft.intern.entity.User;
import com.pinsoft.intern.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository  userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getALl() {
        return userRepository.findAll();
    }
}
