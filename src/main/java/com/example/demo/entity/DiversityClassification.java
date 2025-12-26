package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DiversityClassification {

    @Id
    @GeneratedValue
    private Long id;

    private boolean isActive = true;
    private LocalDateTime createdAt;

    public DiversityClassification() {}

    public void preSave() {
        createdAt = LocalDateTime.now();
    }
}
