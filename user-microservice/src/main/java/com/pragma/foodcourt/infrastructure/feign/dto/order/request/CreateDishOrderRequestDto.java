package com.pragma.foodcourt.infrastructure.feign.dto.order.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDishOrderRequestDto {

    private Long idOrder;
    private Long idDish;
    private int amount;

}
