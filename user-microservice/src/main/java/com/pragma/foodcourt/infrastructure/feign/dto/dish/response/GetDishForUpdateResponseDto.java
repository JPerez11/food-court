package com.pragma.foodcourt.infrastructure.feign.dto.dish.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDishForUpdateResponseDto {

    private int price;
    private String description;

}
