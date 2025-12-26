package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repo;

    public SupplierServiceImpl(SupplierRepository repo) {
        this.repo = repo;
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Supplier deactivateSupplier(Long id) {
        Supplier supplier = repo.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setActive(false);
            return repo.save(supplier);
        }
        return null;
    }
}
