package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiversityClassificationServiceImpl implements DiversityClassificationService {

    private final DiversityClassificationRepository repository;

    @Autowired
    public DiversityClassificationServiceImpl(DiversityClassificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public DiversityClassification createClassification(DiversityClassification classification) {
        return repository.save(classification);
    }

    @Override
    public List<DiversityClassification> getActiveClassifications() {
        return repository.findAll()
                .stream()
                .filter(DiversityClassification::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public List<DiversityClassification> getAllClassifications() {
        return repository.findAll();
    }

    @Override
    public DiversityClassification deleteClassification(Long id) {
        DiversityClassification classification = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classification not found"));
        repository.delete(classification);
        return classification;
    }
}
