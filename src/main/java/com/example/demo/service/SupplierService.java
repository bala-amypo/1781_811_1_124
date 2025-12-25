package com.example.demo.service;

import com.example.demo.entity.Supplier;
import java.util.List;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    Supplier getSupplier(Long id);   // ✅ REQUIRED BY CONTROLLER

    List<Supplier> getAllSuppliers();

    void deactivateSupplier(Long id);
}
