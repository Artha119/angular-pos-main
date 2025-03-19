package com.artha.angular_pos_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "place_order")
public class PlaceOrder {
    @Id
    private String propertyId;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Item> item;




}
