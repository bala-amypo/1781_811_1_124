package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository repo;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository repo) {
        this.repo = repo;
    }

    public PurchaseOrder createPurchaseOrder(PurchaseOrder po) {
        return repo.save(po);
    }

    public List<PurchaseOrder> getPurchaseOrdersBySupplier(long supplierId) {
        return repo.findAll();
    }
}
