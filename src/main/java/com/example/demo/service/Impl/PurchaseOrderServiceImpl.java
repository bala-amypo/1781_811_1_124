package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.PurchaseOrderService;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepo;
    private final SupplierRepository supplierRepo;
    private final SpendCategoryRepository categoryRepo;

    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository poRepo,
            SupplierRepository supplierRepo,
            SpendCategoryRepository categoryRepo) {

        this.poRepo = poRepo;
        this.supplierRepo = supplierRepo;
        this.categoryRepo = categoryRepo;
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {

        if (po.getAmount().compareTo(BigDecimal.ZERO) <= 0)
            throw new BadRequestException("Amount must be positive");

        Supplier s = supplierRepo.findById(po.getSupplier().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        SpendCategory c = categoryRepo.findById(po.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        if (!Boolean.TRUE.equals(s.getIsActive()) || !Boolean.TRUE.equals(c.getActive()))
            throw new BadRequestException("Inactive entity");

        return poRepo.save(po);
    }

    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        return poRepo.findBySupplier_Id(supplierId);
    }
}
