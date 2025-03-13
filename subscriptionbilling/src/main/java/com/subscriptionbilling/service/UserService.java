package com.subscriptionbilling.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subscriptionbilling.entity.User;
import com.subscriptionbilling.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int register(User user) {
        return userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

