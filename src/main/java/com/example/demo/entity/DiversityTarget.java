package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diversity_targets")
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer targetYear;

    private Double targetPercentage;

    @Column(nullable = false)
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "classification_id", nullable = false)
    private DiversityClassification classification;

    @PrePersist
    public void preSave() {
        this.active = true;
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public Integer getTargetYear() {
        return targetYear;
    }

    public void setTargetYear(Integer targetYear) {
        this.targetYear = targetYear;
    }

    public Double getTargetPercentage() {
        return targetPercentage;
    }

    public void setTargetPercentage(Double targetPercentage) {
        this.targetPercentage = targetPercentage;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public DiversityClassification getClassification() {
        return classification;
    }

    public void setClassification(DiversityClassification classification) {
        this.classification = classification;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
