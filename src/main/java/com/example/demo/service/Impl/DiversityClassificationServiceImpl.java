package com.example.demo.service.impl;

import com.example.demo.entity.DiversityClassification;
import com.example.demo.repository.DiversityClassificationRepository;
import com.example.demo.service.DiversityClassificationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiversityClassificationServiceImpl implements DiversityClassificationService {

    private final DiversityClassificationRepository repo;

    public DiversityClassificationServiceImpl(DiversityClassificationRepository repo) {
        this.repo = repo;
    }

    @Override
    public DiversityClassification createClassification(DiversityClassification classification) {
        return repo.save(classification);
    }

    @Override
    public List<DiversityClassification> getAllClassifications() {
        return repo.findAll();
    }

    @Override
    public List<DiversityClassification> getActiveClassifications() {
        return repo.findAll()
                .stream()
                .filter(DiversityClassification::getActive)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClassification(Long id) {
        repo.deleteById(id);
    }
}
