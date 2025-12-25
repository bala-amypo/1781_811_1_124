package com.example.demo.service.impl;

import com.example.demo.entity.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderRepository poRepo;

    public PurchaseOrderServiceImpl(PurchaseOrderRepository poRepo) {
        this.poRepo = poRepo;
    }

    @Override
    public PurchaseOrder create(PurchaseOrder po) {
        return poRepo.save(po);
    }

    @Override
    public List<PurchaseOrder> getOrdersByCategory(Long categoryId) {
        return poRepo.findByCategory_Id(categoryId);
    }

    @Override
    public List<PurchaseOrder> getOrdersBySupplier(Long supplierId) {
        return poRepo.findBySupplier_Id(supplierId);
    }
}
