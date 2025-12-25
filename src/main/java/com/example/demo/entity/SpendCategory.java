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

    public Long getId() { return id; }
    public Boolean getActive() { return active; }
    public String getName() { return name; }

    public void setId(Long id) { this.id = id; }
    public void setActive(Boolean active) { this.active = active; }
    public void setName(String name) { this.name = name; }
}
