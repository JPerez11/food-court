package com.pragma.foodcourt.infrastructure.feign.dto.dish.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadDishResponseDto {

    private String name;
    private int price;
    private String description;
    private String urlImage;
    private boolean active;


}
