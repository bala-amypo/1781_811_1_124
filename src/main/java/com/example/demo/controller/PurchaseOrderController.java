package com.example.demo.controller;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseOrder createPurchaseOrder(
            @RequestBody PurchaseOrder order) {
        return service.createPurchaseOrder(order);
    }

    @GetMapping("/supplier/{supplierId}")
    public List<PurchaseOrder> getOrdersBySupplier(
            @PathVariable Long supplierId) {
        return service.getOrdersBySupplier(supplierId);
    }

    @GetMapping("/category/{categoryId}")
    public List<PurchaseOrder> getOrdersByCategory(
            @PathVariable Long categoryId) {
        return service.getOrdersByCategory(categoryId);
    }
}
