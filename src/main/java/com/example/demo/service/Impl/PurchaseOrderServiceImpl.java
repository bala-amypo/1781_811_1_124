package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.entity.SpendCategory;
import com.example.demo.entity.Supplier;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.repository.SpendCategoryRepository;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.PurchaseOrderService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository orderRepository;
    private final SupplierRepository supplierRepository;
    private final SpendCategoryRepository categoryRepository;

    public PurchaseOrderServiceImpl(
            PurchaseOrderRepository orderRepository,
            SupplierRepository supplierRepository,
            SpendCategoryRepository categoryRepository) {
        this.orderRepository = orderRepository;
        this.supplierRepository = supplierRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public PurchaseOrder createPurchaseOrder(PurchaseOrder order) {

        Supplier supplier = supplierRepository.findById(
                order.getSupplier().getId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        SpendCategory category = categoryRepository.findById(
                order.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        if (!supplier.getIsActive() || !category.getActive()) {
            throw new RuntimeException("Inactive supplier or category");
        }

        return orderRepository.save(order);
    }

    @Override
    public List<PurchaseOrder> getOrdersBySupplier(Long supplierId) {
        return orderRepository.findBySupplierId(supplierId);
    }

    @Override
    public List<PurchaseOrder> getOrdersByCategory(Long categoryId) {
        return orderRepository.findByCategoryId(categoryId);
    }
}
