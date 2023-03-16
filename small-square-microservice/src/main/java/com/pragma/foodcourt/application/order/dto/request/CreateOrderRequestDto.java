package com.pragma.foodcourt.application.order.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequestDto {

    private Long idClient;
    private LocalDate date = LocalDate.now();
    private String status = "PENDING";
    private Long idChef;
    private Long idRestaurant;

}
