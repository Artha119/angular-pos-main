package com.artha.angular_pos_backend.api;

import com.artha.angular_pos_backend.dto.requestDto.RequestCustomerDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponseCustomerDto;
import com.artha.angular_pos_backend.service.CustomerService;
import com.artha.angular_pos_backend.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestCustomerDto dto){
        customerService.create(dto);
        return new ResponseEntity<>(new StandardResponse(201,"customer created!",null), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@RequestBody RequestCustomerDto dto,@PathVariable String id){
        customerService.update(dto, id);
        return new ResponseEntity<>(new StandardResponse(201,"customer updated!",null), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        customerService.delete(id);
        return new ResponseEntity<>(new StandardResponse(204,"customer deleted!",null), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        ResponseCustomerDto data = customerService.getById(id);
        return new ResponseEntity<>(new StandardResponse(200,"customer found!",data), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAll(){
        List<ResponseCustomerDto> list = customerService.getAll();
        return new ResponseEntity<>(new StandardResponse(200,"customer found!",list), HttpStatus.OK);
    }


}
