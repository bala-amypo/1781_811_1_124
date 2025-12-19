package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String registrationNumber;
    private String email;
    private boolean active = true;

    @OneToMany(mappedBy = "supplier")
    private List<PurchaseOrder> orders;

    public Supplier() {}

    public Long getId() { return id; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
