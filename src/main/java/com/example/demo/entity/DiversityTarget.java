package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "diversity_targets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiversityTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer targetYear;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private DiversityClassification classification;

    @Min(0)
    @Max(100)
    private Double targetPercentage;

    private Boolean active = true;
}
