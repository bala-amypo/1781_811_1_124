package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "spend_categories")
public class SpendCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean active = true;

    public SpendCategory() {
    }

    /* =====================================================
       Lifecycle method REQUIRED by tests
       ===================================================== */
    @PrePersist
    public void preSave() {
        this.active = true;
    }

    /* =====================================================
       Legacy + Test-required methods
       ===================================================== */

    // Used by tests
    public boolean getActive() {
        return active;
    }

    // Used by tests
    public void setActive(boolean active) {
        this.active = active;
    }

    // Used by services
    public boolean getIsActive() {
        return active;
    }

    public void setIsActive(boolean active) {
        this.active = active;
    }

    // JavaBean standard (optional but safe)
    public boolean isActive() {
        return active;
    }

    /* =====================================================
       Standard getters/setters
       ===================================================== */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
