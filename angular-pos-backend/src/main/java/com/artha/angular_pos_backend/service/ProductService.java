package com.artha.angular_pos_backend.service;

import com.artha.angular_pos_backend.dto.requestDto.RequestProductDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponseProductDto;

import java.util.List;

public interface ProductService {
    void create(RequestProductDto productDto);
    void update(RequestProductDto productDto,String id);

    void delete(String id);
    ResponseProductDto getById(String id);

    List<ResponseProductDto> getAll();
}
