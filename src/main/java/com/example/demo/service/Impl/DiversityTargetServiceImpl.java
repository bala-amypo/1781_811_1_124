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

    public List<DiversityTarget> getTargetsByYear(int year) {
        return repo.findByTargetYear(year);
    }

    public List<DiversityTarget> getAllTargets() {
        return repo.findAll();
    }

    public void deactivateTarget(long id) {
        repo.findById(id).ifPresent(t -> {
            t.setActive(false);
            repo.save(t);
        });
    }
}
