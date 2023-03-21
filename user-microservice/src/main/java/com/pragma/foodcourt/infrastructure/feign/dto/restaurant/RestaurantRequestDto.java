package com.pragma.foodcourt.infrastructure.feign.dto.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequestDto {

    private String name;
    private int nit;
    private String address;
    private String phone;
    private String urlLogo;
    private Long idOwner;

}

