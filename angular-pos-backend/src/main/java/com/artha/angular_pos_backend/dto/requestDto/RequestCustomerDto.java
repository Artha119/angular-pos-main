package com.artha.angular_pos_backend.dto.requestDto;

import com.artha.angular_pos_backend.entity.PlaceOrder;
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
public class RequestCustomerDto {


    private String customerName;

    private String customerAddress;

    private double customerSalary;


}
