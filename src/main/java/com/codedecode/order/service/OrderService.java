package com.codedecode.order.service;

import com.codedecode.order.dto.OrderDTO;
import com.codedecode.order.dto.OrderDTOFromFE;
import com.codedecode.order.dto.UserDTO;
import com.codedecode.order.entity.Order;
import com.codedecode.order.mappers.OrderMapper;
import com.codedecode.order.repo.OrderRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderDTOInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
       UserDTO userDTO =  fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemList(),orderDetails.getRestaurant(),userDTO);
        orderRepo.save(orderToBeSaved);
        OrderMapper mapper = new OrderMapper();
        return mapper.mapToOrderDTO(orderToBeSaved);

    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
     return restTemplate.getForObject("http://USER-SERVICE/user/"+userId,UserDTO.class);
    }
}
