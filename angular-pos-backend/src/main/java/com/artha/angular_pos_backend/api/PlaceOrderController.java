package com.artha.angular_pos_backend.api;

import com.artha.angular_pos_backend.dto.requestDto.RequestPlaceOrderDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponsePlaceOrderDto;
import com.artha.angular_pos_backend.service.PlaceOrderService;
import com.artha.angular_pos_backend.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/place_order")
@RequiredArgsConstructor

public class PlaceOrderController {

    private final PlaceOrderService placeOrderService;

    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestPlaceOrderDto dto){

        placeOrderService.createOrder(dto);
        return new ResponseEntity<>(new StandardResponse(201,"Order Created!",null), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAll(){

        List<ResponsePlaceOrderDto> all = placeOrderService.getAll();
        return new ResponseEntity<>(
                new StandardResponse(200,"Order List",all),
                HttpStatus.OK
        );
    }

}
