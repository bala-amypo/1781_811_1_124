package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class DiversityTarget {

    @Id @GeneratedValue
    private Long id;

    private Integer targetYear;
    private Double targetPercentage;
    private Boolean active;

    @ManyToOne
    private DiversityClassification classification;

    @PrePersist
    public void preSave() {
        if (active == null) active = true;
    }

    
}
