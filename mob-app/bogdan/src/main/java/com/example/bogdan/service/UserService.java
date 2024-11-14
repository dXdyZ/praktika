package com.example.bogdan.service;

import com.example.bogdan.entity.Users;
import com.example.bogdan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public Optional<Users> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
