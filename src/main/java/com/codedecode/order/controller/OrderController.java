package com.codedecode.order.controller;

import com.codedecode.order.dto.OrderDTO;
import com.codedecode.order.dto.OrderDTOFromFE;
import com.codedecode.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")

public class OrderController {
    @Autowired
    OrderService orderService;
    @CrossOrigin
    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
        OrderDTO saveOrder = orderService.saveOrderDTOInDb(orderDetails);
        return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
    }
    @GetMapping()
    public List<OrderDTO> getAllOrders(){
        return orderService.gettAllOrders();

    }


}
