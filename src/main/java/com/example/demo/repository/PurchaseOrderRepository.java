package com.example.demo.repository;

import com.example.demo.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    // Find all orders for a given category id
    List<PurchaseOrder> findByCategory_Id(Long categoryId);

    // Find all orders for a given supplier id
    List<PurchaseOrder> findBySupplier_Id(Long supplierId);
}
