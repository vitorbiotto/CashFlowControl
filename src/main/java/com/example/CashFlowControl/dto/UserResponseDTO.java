package com.example.CashFlowControl.dto;

import org.springframework.security.core.userdetails.User;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;

    public UserResponseDTO(){}

    public UserResponseDTO(User user) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
