package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int targetYear;

    private double targetPercentage;

    @ManyToOne
    private DiversityClassification classification;

    public DiversityTarget() {
    }

    /* ===============================
       Required by TestNG
       =============================== */

    @PrePersist
    public void preSave() {
        if (targetPercentage < 0) {
            targetPercentage = 0;
        }
    }

    public int getTargetYear() {
        return targetYear;
    }

    public void setTargetYear(int targetYear) {
        this.targetYear = targetYear;
    }

    public double getTargetPercentage() {
        return targetPercentage;
    }

    public void setTargetPercentage(double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public DiversityClassification getClassification() {
        return classification;
    }

    public void setClassification(DiversityClassification classification) {
        this.classification = classification;
    }

    /* ===============================
       Standard getters/setters
       =============================== */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
