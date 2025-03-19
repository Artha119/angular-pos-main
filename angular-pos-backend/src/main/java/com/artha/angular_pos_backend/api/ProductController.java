package com.artha.angular_pos_backend.api;

import com.artha.angular_pos_backend.dto.requestDto.RequestProductDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponseProductDto;
import com.artha.angular_pos_backend.service.ProductService;
import com.artha.angular_pos_backend.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    public ResponseEntity<StandardResponse> create(@RequestBody RequestProductDto dto){
        productService.create(dto);
        return new ResponseEntity<>(new StandardResponse(201,"product created!",null), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> update(@RequestBody RequestProductDto dto,@PathVariable String id){
        productService.update(dto, id);
        return new ResponseEntity<>(new StandardResponse(201,"product updated!",null), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> delete(@PathVariable String id){
        productService.delete(id);
        return new ResponseEntity<>(new StandardResponse(204,"product deleted!",null), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getById(@PathVariable String id){
        ResponseProductDto data = productService.getById(id);
        return new ResponseEntity<>(new StandardResponse(200,"product found!",data), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<StandardResponse> getAll(){
        List<ResponseProductDto> list = productService.getAll();
        return new ResponseEntity<>(new StandardResponse(200,"product found!",list), HttpStatus.OK);
    }

}
