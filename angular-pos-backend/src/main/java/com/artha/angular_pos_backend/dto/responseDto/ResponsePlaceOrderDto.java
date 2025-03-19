package com.artha.angular_pos_backend.dto.responseDto;

import com.artha.angular_pos_backend.entity.Customer;
import com.artha.angular_pos_backend.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponsePlaceOrderDto {
private String OrderId;
private Date createAt;
private String customer;
//private List<Item> item;
private int itemCount;

}
