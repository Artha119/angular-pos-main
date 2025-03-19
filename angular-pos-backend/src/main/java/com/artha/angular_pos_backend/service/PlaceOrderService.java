package com.artha.angular_pos_backend.service;

import com.artha.angular_pos_backend.dto.requestDto.RequestPlaceOrderDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponsePlaceOrderDto;

import java.util.List;

public interface PlaceOrderService {
    public void createOrder(RequestPlaceOrderDto dto);

    public List<ResponsePlaceOrderDto> getAll();
}
