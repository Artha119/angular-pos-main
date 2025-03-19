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
@Entity(name = "product")
public class Product {

    @Id
    private String propertyId;
    @Column(name = "description", nullable = false, length = 225)
    private String description;
    @Column(name = "unit_price", nullable = false, scale = 2)
    private double unitPrice;
    @Column(name = "qty_on_hand", nullable = false, scale = 2)
    private double qtyOnHand;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Item> items;
}
