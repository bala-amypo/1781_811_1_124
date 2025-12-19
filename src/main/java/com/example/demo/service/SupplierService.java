package com.example.demo.service;

import com.example.demo.entity.Supplier;
import java.util.List;

public interface SupplierService {
    Supplier save(Supplier supplier);
    List<Supplier> findAll();
    Supplier deactivate(Long id);
}
