package com.example.libray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Users authenticateUser(String username, String phoneNumber) {
        Users user = userRepository.findByUsernameAndPhoneNumber(username, phoneNumber)
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        return user;
    }

    public void saveUser(Users users) {
        try {
            getByUsernameAndPhoneNumber(users.getUsername(), users.getPhoneNumber());
        } catch (NullPointerException e) {
            userRepository.save(users);
        }
    }

    public Users getByUsernameAndPhoneNumber(String username, String phoneNumber) {
        return userRepository.findByUsernameAndPhoneNumber(username, phoneNumber).orElseThrow(NullPointerException::new);
    }

    public Users getById(Long id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Iterable<Users> getAllUser() {
        return userRepository.findAll();
    }

    public Users getByName(String username) {
        return userRepository.findByUsername(username).orElseThrow(NullPointerException::new);
    }

    public Users getByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElseThrow(NullPointerException::new);
    }
}
