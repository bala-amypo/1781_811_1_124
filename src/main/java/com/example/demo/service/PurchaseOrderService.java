package com.example.demo.service;

import com.example.demo.entity.PurchaseOrder;
import java.util.List;

public interface PurchaseOrderService {

    PurchaseOrder create(PurchaseOrder po);

    List<PurchaseOrder> getOrdersByCategory(Long categoryId);

    List<PurchaseOrder> getOrdersBySupplier(Long supplierId);
}
