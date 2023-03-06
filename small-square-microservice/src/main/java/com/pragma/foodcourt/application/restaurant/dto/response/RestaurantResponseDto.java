package com.pragma.foodcourt.application.restaurant.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantResponseDto {

    private Long id;
    private String name;
    private int nit;
    private String address;
    private String phone;
    private String urlLogo;

}
