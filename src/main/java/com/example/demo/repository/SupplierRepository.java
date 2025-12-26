package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    boolean existsByEmail(String email);

    // ✅ Correct JPA method (field name = active)
    List<Supplier> findByActiveTrue();

    // ✅ Compatibility method for testcases
    default List<Supplier> findByIsActiveTrue() {
        return findByActiveTrue();
    }
}
