package com.example.demo.service;

import com.example.demo.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrder create(PurchaseOrder po); // renamed to match controller

    List<PurchaseOrder> getOrdersByCategory(Long categoryId);

    List<PurchaseOrder> getPurchaseOrdersBySupplier(long supplierId);
}
