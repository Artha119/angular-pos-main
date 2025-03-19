package com.artha.angular_pos_backend.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class RequestProductDto {
    private String description;

    private String unitPrice;

    private double qty;

}
