package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isActive = true;

    public Supplier() {}

    public Supplier(String name) {
        this.name = name;
    }

    @PrePersist
    public void prePersist() {
        this.isActive = true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsActive(boolean active) {
        this.isActive = active;
    }
}
