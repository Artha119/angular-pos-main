package com.artha.angular_pos_backend.service.impl;

import com.artha.angular_pos_backend.dto.requestDto.RequestCustomerDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponseCustomerDto;
import com.artha.angular_pos_backend.entity.Customer;
import com.artha.angular_pos_backend.repository.CustomerRepo;
import com.artha.angular_pos_backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    @Override
    public void create(RequestCustomerDto customerDto) {

        if (customerDto==null){
            throw new RuntimeException("Data Not Found!");
        }

        Customer customer = Customer.builder()
                .propertyId(UUID.randomUUID().toString())
                .customerName(customerDto.getCustomerName())
                .customerSalary(customerDto.getCustomerSalary())
                .customerAddress(customerDto.getCustomerAddress())
                .build();
        customerRepo.save(customer);


    }

    @Override
    public void update(RequestCustomerDto customerDto, String id) {

        if (customerDto==null || id==null){
            throw new RuntimeException("Data Not Found!");
        }

        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()){
            throw new RuntimeException("User Not Found!");
        }

        Customer customer = Customer.builder()
                .propertyId(selectedCustomer.get().getPropertyId())
                .customerName(customerDto.getCustomerName())
                .customerAddress(customerDto.getCustomerAddress())
                .customerSalary(customerDto.getCustomerSalary())
                .build();
        customerRepo.save(customer);

    }

    @Override
    public void delete(String id) {
        if (id.equals(null)){
            throw new RuntimeException("ID Not Found!");
        }

        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()){
            throw new RuntimeException("User Not Found!");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public ResponseCustomerDto getById(String id) {
        if (id.equals(null)){
            throw new RuntimeException("ID Not Found!");
        }

        Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()){
            throw new RuntimeException("User Not Found!");
        }
        return ResponseCustomerDto.builder()
                .propertyId(selectedCustomer.get().getPropertyId())
                .customerName(selectedCustomer.get().getCustomerName())
                .customerAddress(selectedCustomer.get().getCustomerAddress())
                .customerSalary(selectedCustomer.get().getCustomerSalary())
                .build();
    }

    @Override
    public List<ResponseCustomerDto> getAll() {

        List<Customer> customerList = customerRepo.findAll();
        List<ResponseCustomerDto> responseCustomerDtoList = new ArrayList<>();

        if (customerList.stream().count()==0){
            throw new RuntimeException("Data Not Found!");

        }

        for (Customer c:customerList) {
            responseCustomerDtoList.add(
                    ResponseCustomerDto.builder()
                            .propertyId(c.getPropertyId())
                            .customerName(c.getCustomerName())
                            .customerAddress(c.getCustomerAddress())
                            .customerSalary(c.getCustomerSalary())
                            .build());
        }

        return responseCustomerDtoList;

    }

}
