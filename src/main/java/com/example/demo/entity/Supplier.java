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

    public Long getId() { return id; }
    public Boolean getIsActive() { return isActive; }
    public Set<DiversityClassification> getDiversityClassifications() { return diversityClassifications; }
    public String getName() { return name; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setId(Long id) { this.id = id; }
    public void setIsActive(Boolean active) { this.isActive = active; }
    public void setName(String name) { this.name = name; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
