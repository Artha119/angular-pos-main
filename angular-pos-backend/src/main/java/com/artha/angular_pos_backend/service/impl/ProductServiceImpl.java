package com.artha.angular_pos_backend.service.impl;

import com.artha.angular_pos_backend.dto.requestDto.RequestProductDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponseProductDto;
import com.artha.angular_pos_backend.entity.Product;
import com.artha.angular_pos_backend.repository.ProductRepo;
import com.artha.angular_pos_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public void create(RequestProductDto productDto) {
        if (productDto==null){
            throw new RuntimeException("Product Not Found!");
        }

        Product product = Product.builder()
                .propertyId(UUID.randomUUID().toString())
                .description(productDto.getDescription())
                .unitPrice(Double.parseDouble(productDto.getUnitPrice()))
                .qtyOnHand(productDto.getQty())
                .build();
        productRepo.save(product);
    }

    @Override
    public void update(RequestProductDto productDto, String id) {
        if (productDto==null || id==null){
            throw new RuntimeException("Product Not Found!");
        }

        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()){
            throw new RuntimeException("Product Not Found!");
        }

        Product product = Product.builder()
                .propertyId(selectedProduct.get().getPropertyId())
                .description(productDto.getDescription())
                .unitPrice(Double.parseDouble(productDto.getUnitPrice()))
                .qtyOnHand(productDto.getQty())
                .build();
        productRepo.save(product);
    }

    @Override
    public void delete(String id) {
        if (id.equals(null)){
            throw new RuntimeException("Product ID Not Found!");
        }

        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()){
            throw new RuntimeException("Product Not Found!");
        }
        productRepo.deleteById(id);
    }

    @Override
    public ResponseProductDto getById(String id) {
        if (id.equals(null)){
            throw new RuntimeException("Product ID Not Found!");
        }

        Optional<Product> selectedProduct = productRepo.findById(id);
        if (selectedProduct.isEmpty()){
            throw new RuntimeException("User Not Found!");
        }
        return ResponseProductDto.builder()
                .propertyId(selectedProduct.get().getPropertyId())
                .description(selectedProduct.get().getDescription())
                .unitPrice(selectedProduct.get().getUnitPrice())
                .qty(selectedProduct.get().getQtyOnHand())
                .build();
    }

    @Override
    public List<ResponseProductDto> getAll() {

        List<Product> productList = productRepo.findAll();
        List<ResponseProductDto> responseProductDtoList = new ArrayList<>();

        if (productList.stream().count()==0){
            throw new RuntimeException("Product Not Found!");

        }

        for (Product p:productList) {
            responseProductDtoList.add(
                    ResponseProductDto.builder()
                            .propertyId(p.getPropertyId())
                            .description(p.getDescription())
                            .unitPrice(p.getUnitPrice())
                            .qty(p.getQtyOnHand())
                            .build());
        }

        return responseProductDtoList;

    }
}
