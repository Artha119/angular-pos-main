package com.artha.angular_pos_backend.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class StandardResponse {

    private int code;
    private String message;
    private Object data;



}
