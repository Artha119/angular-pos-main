package com.artha.angular_pos_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity(name = "item")
public class Item {

    @Id
    private String propertyId;
    @Column(name = "qty",nullable = false,length = 225)
    private int qty;
    @Column(name = "description",nullable = false,length = 225)
    private String description;
    @Column(name = "net_total",nullable = false,scale = 2)
    private double netTotal;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private PlaceOrder orders;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;


}
