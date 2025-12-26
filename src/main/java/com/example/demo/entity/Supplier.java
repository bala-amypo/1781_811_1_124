package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String registrationNumber;
    private boolean isActive = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DiversityClassification> diversityClassifications = new ArrayList<>();

    public Supplier() {}

    // getters & setters
    public Long getId() { return id; }

    public void setEmail(String email) { this.email = email; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public List<DiversityClassification> getDiversityClassifications() {
        return diversityClassifications;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
}
