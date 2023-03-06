package com.pragma.foodcourt.application.dish.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindAllDishesResponseDto {

    private String name;
    private int price;
    private String description;
    private String urlImage;
    private boolean active;


}
