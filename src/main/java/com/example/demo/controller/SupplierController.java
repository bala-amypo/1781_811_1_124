package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /* ===== Constructor REQUIRED by tests ===== */
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /* Spring default */
    public SupplierController() {}

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(
            @RequestBody Supplier supplier) {
        return ResponseEntity.ok(
                supplierService.createSupplier(supplier));
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(
                supplierService.getAllSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplier(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                supplierService.getSupplierById(id));
    }
}
