package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Supplier;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(Long id);

    void deactivateSupplier(Long supplierId);
}
