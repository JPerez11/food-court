package com.pragma.foodcourt.infrastructure.feign.dto.order.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private ReadOrderResponseDto order;
    private ReadDishOrderResponseDto dishOrder;

}
