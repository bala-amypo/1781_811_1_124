package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.PurchaseOrderService;

import java.util.List;

public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepo;

    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository poRepo,
            SupplierRepository supplierRepo,
            SpendCategoryRepository categoryRepo
    ) {
        this.poRepo = poRepo;
    }

    @Override
    public PurchaseOrder create(PurchaseOrder po) {
        return poRepo.save(po);
    }

    @Override
    public List<PurchaseOrder> getOrdersByCategory(Long categoryId) {
        return poRepo.findAll(); // stub, enough to compile
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(long supplierId) {
        return poRepo.findAll();
    }
}
