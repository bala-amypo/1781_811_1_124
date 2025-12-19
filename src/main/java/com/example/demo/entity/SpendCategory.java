package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "spend_categories")
public class SpendCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean active = true;

    public SpendCategory() {}

    public boolean isActive() { return active; }
}
