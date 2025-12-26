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

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return repo.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return repo.findAll();
    }

    @Override
    public Supplier getSupplier(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        supplier.setId(id);
        return repo.save(supplier);
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

    @Override
    public void deleteSupplier(Long id) {
        repo.deleteById(id);
    }
}
