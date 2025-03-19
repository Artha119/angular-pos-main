package com.artha.angular_pos_backend.dto.requestDto;

import com.artha.angular_pos_backend.entity.Customer;
import com.artha.angular_pos_backend.entity.Item;
import com.artha.angular_pos_backend.entity.Product;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class RequestPlaceOrderDto {
    private Customer customer;
    private List<Item> items;


}
