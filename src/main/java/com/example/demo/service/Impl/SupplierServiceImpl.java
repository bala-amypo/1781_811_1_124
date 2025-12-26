package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    public SupplierServiceImpl(SupplierRepository repository) {
        this.repository = repository;
    }

    public Supplier createSupplier(Supplier supplier) {
        return repository.save(supplier);
    }

    public List<Supplier> getAllSuppliers() {
        return repository.findAll();
    }

    public Supplier getSupplierById(long id) {
        return repository.findById(id).orElseThrow();
    }
}
