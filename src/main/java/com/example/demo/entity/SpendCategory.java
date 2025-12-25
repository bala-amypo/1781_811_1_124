package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class SpendCategory {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private Boolean active;

    @PrePersist
    public void preSave() {
        if (active == null) active = true;
    }

    
}
