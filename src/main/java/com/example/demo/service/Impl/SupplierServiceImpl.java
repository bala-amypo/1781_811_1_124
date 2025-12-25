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

    private final SupplierRepository supplierRepo;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        supplier.setIsActive(true); // default new suppliers as active
        return supplierRepo.save(supplier);
    }

    @Override
    public Supplier getSupplier(Long id) {
        Optional<Supplier> optionalSupplier = supplierRepo.findById(id);
        if (optionalSupplier.isPresent()) {
            return optionalSupplier.get();
        } else {
            throw new RuntimeException("Supplier not found with ID: " + id);
        }
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Supplier existingSupplier = getSupplier(id);
        existingSupplier.setName(updatedSupplier.getName());
        existingSupplier.setEmail(updatedSupplier.getEmail());
        existingSupplier.setPhone(updatedSupplier.getPhone());
        existingSupplier.setAddress(updatedSupplier.getAddress());
        // keep isActive as is unless you explicitly change it
        return supplierRepo.save(existingSupplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        Supplier supplier = getSupplier(id);
        supplierRepo.delete(supplier);
    }

    @Override
    public Supplier deactivateSupplier(Long id) {
        Supplier supplier = getSupplier(id);
        supplier.setIsActive(false); // deactivate
        return supplierRepo.save(supplier);
    }
}
