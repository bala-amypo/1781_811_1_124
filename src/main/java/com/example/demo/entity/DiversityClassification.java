package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DiversityClassification {

    @Id @GeneratedValue
    private Long id;

    private String code;
    private Boolean active;

    @PrePersist
    public void preSave() {
        if (active == null) active = true;
        if (code != null) code = code.toUpperCase();
    }

    
}
