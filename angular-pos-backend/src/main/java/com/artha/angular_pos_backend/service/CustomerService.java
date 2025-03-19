package com.artha.angular_pos_backend.service;

import com.artha.angular_pos_backend.dto.requestDto.RequestCustomerDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponseCustomerDto;

import java.util.List;

public interface CustomerService {

    void create(RequestCustomerDto customerDto);
    void update(RequestCustomerDto customerDto,String id);

    void delete(String id);
    ResponseCustomerDto getById(String id);

    List<ResponseCustomerDto> getAll();


}
