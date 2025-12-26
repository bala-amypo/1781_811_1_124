package com.example.demo.service;

import com.example.demo.entity.Supplier;

public interface SupplierService {

    Supplier updateSupplier(Long id, Supplier supplier);

    Supplier deactivateSupplier(Long id);

    void deleteSupplier(Long id);
}
