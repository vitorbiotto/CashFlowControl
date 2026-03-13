package com.example.CashFlowControl.service;

import com.example.CashFlowControl.entity.User;
import com.example.CashFlowControl.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return this.userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateById(Long userId, User newUser) {

        User oldUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));

        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPassword(newUser.getPassword());

        return userRepository.save(oldUser);
    }
}
