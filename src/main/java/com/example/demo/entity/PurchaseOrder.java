package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String notes;

    @ManyToOne
    private Supplier supplier;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
