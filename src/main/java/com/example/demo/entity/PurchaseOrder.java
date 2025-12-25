package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class PurchaseOrder {

    @Id @GeneratedValue
    private Long id;

    private String poNumber;
    private BigDecimal amount;
    private LocalDate dateIssued;
    private String notes;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private SpendCategory category;

    public BigDecimal getAmount() { return amount; }
    public Supplier getSupplier() { return supplier; }
    public SpendCategory getCategory() { return category; }
    public LocalDate getDateIssued() { return dateIssued; }
    public String getPoNumber() { return poNumber; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public void setCategory(SpendCategory category) { this.category = category; }
    public void setDateIssued(LocalDate dateIssued) { this.dateIssued = dateIssued; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }
    public void setNotes(String notes) { this.notes = notes; }
}
