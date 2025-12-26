package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Supplier;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    /* Constructor required by tests */
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierServiceImpl() {}

    @Override
    public Supplier createSupplier(Supplier supplier) {

        if (!supplier.isActive()) {
            throw new BadRequestException("Supplier is inactive");
        }

        if (supplierRepository.existsByEmail(supplier.getEmail())) {
            throw new BadRequestException("Supplier with this email already exists");
        }

        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));
    }

    @Override
    public void deactivateSupplier(Long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Supplier not found"));

        supplier.setIsActive(false);
        supplierRepository.save(supplier);
    }
}
