package com.example.demo.service;

import com.example.demo.entity.DiversityClassification;
import java.util.List;

public interface DiversityClassificationService {

    DiversityClassification createClassification(DiversityClassification classification);

    List<DiversityClassification> getAllClassifications();

    List<DiversityClassification> getActiveClassifications();

    void deleteClassification(Long id);
}
