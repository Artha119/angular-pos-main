package com.artha.angular_pos_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "customer")
public class Customer {

    @Id
    private String propertyId;
    @Column(name = "customer_name",nullable = false,length = 225)
    private String customerName;
    @Column(name = "customer_address",nullable = false,length = 225)
    private String customerAddress;
    @Column(name = "customer_salary",nullable = false, scale = 2)
    private double customerSalary;
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<PlaceOrder> orders;



}
