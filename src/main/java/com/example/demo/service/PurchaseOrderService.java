package com.example.demo.service;

import com.example.demo.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrder create(PurchaseOrder po); // ✅ REQUIRED

    List<PurchaseOrder> getPurchaseOrdersBySupplier(Long supplierId);

    List<PurchaseOrder> getOrdersByCategory(Long categoryId);
}
