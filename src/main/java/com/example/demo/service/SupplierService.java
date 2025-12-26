package com.example.demo.service;

import com.example.demo.entity.Supplier;
import java.util.List;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(long id);
}
