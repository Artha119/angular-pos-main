package com.artha.angular_pos_backend.service.impl;

import com.artha.angular_pos_backend.dto.requestDto.RequestPlaceOrderDto;
import com.artha.angular_pos_backend.dto.responseDto.ResponsePlaceOrderDto;
import com.artha.angular_pos_backend.entity.Item;
import com.artha.angular_pos_backend.entity.PlaceOrder;
import com.artha.angular_pos_backend.entity.Product;
import com.artha.angular_pos_backend.repository.ItemRepo;
import com.artha.angular_pos_backend.repository.PlaceOrderRepo;
import com.artha.angular_pos_backend.service.PlaceOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PlaceOrderServiceImpl implements PlaceOrderService {

    private final PlaceOrderRepo placeOrderRepo;
    private final ItemRepo itemRepo;

    @Override
    public void createOrder(RequestPlaceOrderDto dtoList) {
        if (dtoList == null) {
            throw new RuntimeException("data was not found!");
        }

        PlaceOrder createdOrder = PlaceOrder.builder()
                .propertyId(UUID.randomUUID().toString())
                .date(new Date())
                .customer(dtoList.getCustomer())
                .build();


        placeOrderRepo.save(createdOrder);



        for (Item dto:dtoList.getItems()) {


            Optional<PlaceOrder> selectedOrder = placeOrderRepo.findById(createdOrder.getPropertyId());

            if (selectedOrder.isEmpty()){
                throw new RuntimeException("order not found!");
            }

            PlaceOrder selectedPlaceOrder = PlaceOrder.builder()
                    .propertyId(selectedOrder.get().getPropertyId())
                    .date(selectedOrder.get().getDate())
                    .customer(selectedOrder.get().getCustomer())
                    .build();

            Item selectedItem = Item.builder()
                    .propertyId(UUID.randomUUID().toString())
                    .description(dto.getDescription())
                    .orders(selectedPlaceOrder)
                    .netTotal(dto.getNetTotal())
                    .qty(dto.getQty())
                    .product(dto.getProduct())
                    .build();
            itemRepo.save(selectedItem);


        }

    }

    @Override
    public List<ResponsePlaceOrderDto> getAll() {
        List<ResponsePlaceOrderDto> responsePlaceOrderDtoList= new ArrayList<>();
        List<PlaceOrder> allOrderData = placeOrderRepo.findAll();

        for (PlaceOrder p:allOrderData) {
            ResponsePlaceOrderDto build = ResponsePlaceOrderDto.builder()
                    .OrderId(p.getPropertyId())
                    .createAt(p.getDate())
                    .customer(p.getCustomer().getCustomerName())
                    .itemCount((int) p.getItem().stream().count())
                    .build();
                    responsePlaceOrderDtoList.add(build);
        }
        return responsePlaceOrderDtoList;
    }
}
