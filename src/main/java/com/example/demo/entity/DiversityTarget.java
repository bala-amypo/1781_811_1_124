package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DiversityTarget {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime createdAt;

    public DiversityTarget() {}

    public void preSave() {
        createdAt = LocalDateTime.now();
    }
}
