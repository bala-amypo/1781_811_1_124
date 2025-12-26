package com.example.demo.service.impl;

import com.example.demo.entity.DiversityTarget;
import com.example.demo.repository.DiversityTargetRepository;
import com.example.demo.service.DiversityTargetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversityTargetServiceImpl implements DiversityTargetService {

    private final DiversityTargetRepository repo;

    public DiversityTargetServiceImpl(DiversityTargetRepository repo) {
        this.repo = repo;
    }

    @Override
    public DiversityTarget createTarget(DiversityTarget target) {
        return repo.save(target);
    }

    @Override
    public List<DiversityTarget> getTargetsByYear(int year) {
        return repo.findByTargetYear(year);
    }

    @Override
    public List<DiversityTarget> getAllTargets() {
        return repo.findAll();
    }

    @Override
    public DiversityTarget deactivateTarget(Long id) {
        DiversityTarget target = repo.findById(id).orElse(null);
        if (target != null) {
            target.setActive(false);
            return repo.save(target);
        }
        return null;
    }
}
