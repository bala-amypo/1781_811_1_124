package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id @GeneratedValue
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public UserAccount() {}

    public UserAccount(Long id, String name, String email, String password, String role) {
        this.id = id;
        this.fullName = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @PrePersist
    public void prePersist() {
        if (role == null) role = "USER";
        createdAt = LocalDateTime.now();
    }

    
}
