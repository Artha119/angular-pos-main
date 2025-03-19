package com.artha.angular_pos_backend.service;

import com.artha.angular_pos_backend.dto.requestDto.RequestApplicationUserDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponseApplicationUserDto;



public interface ApplicationUserService {
    void register(RequestApplicationUserDto dto);
    boolean login(String email,String password);

    ResponseApplicationUserDto getByEmail(String email);
}
