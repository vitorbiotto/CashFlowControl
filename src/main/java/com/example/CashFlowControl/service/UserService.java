package com.example.CashFlowControl.service;

import com.example.CashFlowControl.entity.User;
import com.example.CashFlowControl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
}
