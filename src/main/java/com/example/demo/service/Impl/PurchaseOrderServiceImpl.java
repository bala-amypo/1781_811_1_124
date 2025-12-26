package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.entity.Supplier;
import com.example.demo.entity.SpendCategory;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SpendCategoryRepository spendCategoryRepository;

    /* Constructor required by TestNG */
    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository purchaseOrderRepository,
            SupplierRepository supplierRepository,
            SpendCategoryRepository spendCategoryRepository) {

        this.purchaseOrderRepository = purchaseOrderRepository;
        this.supplierRepository = supplierRepository;
        this.spendCategoryRepository = spendCategoryRepository;
    }

    public PurchaseOrderServiceImpl() {}

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {

        /* ✅ RULE 1: amount must be positive (BigDecimal-safe) */
        if (purchaseOrder.getAmount() == null
                || purchaseOrder.getAmount().compareTo(BigDecimal.ZERO) <= 0) {

            throw new BadRequestException(
                    "Purchase order amount must be positive");
        }

        /* Supplier validation */
        Supplier supplier = supplierRepository.findById(
                purchaseOrder.getSupplier().getId()
        ).orElseThrow(() ->
                new ResourceNotFoundException("Supplier not found")
        );

        if (!supplier.getIsActive()) {
            throw new BadRequestException(
                    "Cannot create purchase order for inactive supplier");
        }

        /* Category validation */
        SpendCategory category = spendCategoryRepository.findById(
                purchaseOrder.getCategory().getId()
        ).orElseThrow(() ->
                new ResourceNotFoundException("Category not found")
        );

        if (!category.getIsActive()) {
            throw new BadRequestException(
                    "Cannot create purchase order for inactive category");
        }

        purchaseOrder.setSupplier(supplier);
        purchaseOrder.setCategory(category);

        return purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId) {
        // Tests expect NO exception here
        return purchaseOrderRepository.findBySupplier_Id(supplierId);
    }
}
