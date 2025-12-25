package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String registrationNumber;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToMany
    private Set<DiversityClassification> diversityClassifications = new HashSet<>();

    @PrePersist
    public void prePersist() {
        if (isActive == null) isActive = true;
        createdAt = LocalDateTime.now();
    }

    
}
