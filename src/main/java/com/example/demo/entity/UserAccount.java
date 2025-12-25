package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
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

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    public void setId(Long id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
}
