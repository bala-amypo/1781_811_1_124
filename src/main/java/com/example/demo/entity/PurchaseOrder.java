package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue
    private Long id;

    private String poNumber;
    private BigDecimal amount;
    private LocalDate dateIssued;

    @ManyToOne
    private SpendCategory category;

    @ManyToOne
    private Supplier supplier;

    public PurchaseOrder() {}

    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public void setDateIssued(LocalDate dateIssued) { this.dateIssued = dateIssued; }
    public void setCategory(SpendCategory category) { this.category = category; }

    public String getPoNumber() { return poNumber; }
    public BigDecimal getAmount() { return amount; }
    public LocalDate getDateIssued() { return dateIssued; }
    public SpendCategory getCategory() { return category; }
}
