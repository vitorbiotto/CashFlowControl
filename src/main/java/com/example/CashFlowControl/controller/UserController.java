package com.example.CashFlowControl.controller;

import com.example.CashFlowControl.entity.User;
import com.example.CashFlowControl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:5173") //Permite que o react acesse a API
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@RequestParam Long userId) {
        userService.deleteById(userId);
    }

    @PutMapping("/{id}")
    public User updateById(@PathVariable Long userId,
                           @RequestBody User user) {
        return userService.updateById(userId, user);
    }
}
