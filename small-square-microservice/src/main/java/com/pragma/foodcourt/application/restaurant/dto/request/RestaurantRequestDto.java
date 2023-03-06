package com.pragma.foodcourt.application.restaurant.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RestaurantRequestDto {

    private String name;
    private int nit;
    private String address;
    private String phone;
    private String urlLogo;
    private Long idOwner;

}
