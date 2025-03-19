package com.artha.angular_pos_backend.dto.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseApplicationUserDto {

    private String propertyId;

    private String email;

    private String password;

    private String fullName;

    private boolean isActive;
}
