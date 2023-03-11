package com.pragma.foodcourt.application.dish.handler;

import com.pragma.foodcourt.application.dish.dto.response.FindAllDishesResponseDto;

import java.util.List;

public interface IReadDishHandler {

    List<FindAllDishesResponseDto> findAllDish();

    List<FindAllDishesResponseDto>  findDishByIdRestaurantOrderByIdCategory(Long id);

}
