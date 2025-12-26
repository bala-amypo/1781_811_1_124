package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplier(Long id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        return optionalSupplier.orElseThrow(() -> 
            new RuntimeException("Supplier not found with id: " + id)
        );
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        if (supplier.getId() == null) {
            throw new IllegalArgumentException("Supplier ID cannot be null for update.");
        }
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
