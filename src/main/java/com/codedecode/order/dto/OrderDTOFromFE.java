package com.codedecode.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDTOFromFE {
    private List<FoodItemDTO> foodItemList;
    Integer userId;
    Restaurant restaurant;

}
