package com.codedecode.order.mappers;

import com.codedecode.order.dto.OrderDTO;
import com.codedecode.order.entity.Order;

public class OrderMapper {
public static OrderDTO mapToOrderDTO(Order order){
    return new OrderDTO(
            order.getOrderId(),
            order.getFoodItemList(),
            order.getRestaurant(),
            order.getUserDTO()
    );
}
public static  Order mapToOrder(OrderDTO orderDTO){
    return new Order(
            orderDTO.getOrderId(),
            orderDTO.getFoodItemList(),
            orderDTO.getRestaurant(),
            orderDTO.getUserDTO()
    );
    }
}
