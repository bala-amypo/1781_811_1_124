package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String firstName;
    private String lastName;
    private String role;

    private LocalDateTime createdAt;

    public UserAccount() {}

    public UserAccount(Long id, String email, String firstName, String lastName, String role) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}
