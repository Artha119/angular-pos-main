package com.artha.angular_pos_backend.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class RequestApplicationUserDto {

    private String email;

    private String password;

    private String fullName;

    private boolean isActive;

}
