package com.artha.angular_pos_backend.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseCustomerDto {

    private String propertyId;
    private String customerName;

    private String customerAddress;

    private double customerSalary;
}
