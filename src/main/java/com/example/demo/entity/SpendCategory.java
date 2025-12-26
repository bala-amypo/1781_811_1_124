package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class SpendCategory {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean isActive = true;

    public SpendCategory() {}

    public Long getId() { return id; }
}
