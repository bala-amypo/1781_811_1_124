package com.example.demo.config;

import com.example.demo.repository.*;
import com.example.demo.service.*;
import com.example.demo.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public SupplierService supplierService(SupplierRepository repo) {
        return new SupplierServiceImpl(repo);
    }

    @Bean
    public SpendCategoryService spendCategoryService(SpendCategoryRepository repo) {
        return new SpendCategoryServiceImpl(repo);
    }

    @Bean
    public DiversityClassificationService diversityClassificationService(
            DiversityClassificationRepository repo) {
        return new DiversityClassificationServiceImpl(repo);
    }

    @Bean
    public DiversityTargetService diversityTargetService(
            DiversityTargetRepository repo) {
        return new DiversityTargetServiceImpl(repo);
    }

    @Bean
    public PurchaseOrderService purchaseOrderService(
            PurchaseOrderRepository poRepo,
            SupplierRepository supplierRepo,
            SpendCategoryRepository categoryRepo) {
        return new PurchaseOrderServiceImpl(poRepo, supplierRepo, categoryRepo);
    }

    @Bean
    public UserAccountService userAccountService(
            UserAccountRepository repo) {
        return new UserAccountServiceImpl(repo);
    }
}
