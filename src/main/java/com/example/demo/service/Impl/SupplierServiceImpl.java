package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repo;

    public SupplierServiceImpl(SupplierRepository repo) {
        this.repo = repo;
    }

    public Supplier save(Supplier supplier) {
        return repo.save(supplier);
    }

    public List<Supplier> findAll() {
        return repo.findAll();
    }

    public Supplier deactivate(Long id) {
        Supplier s = repo.findById(id).orElseThrow();
        s.setActive(false);
        return repo.save(s);
    }
}
