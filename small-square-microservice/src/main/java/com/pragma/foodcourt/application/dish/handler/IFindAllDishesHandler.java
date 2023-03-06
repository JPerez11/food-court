package com.pragma.foodcourt.application.dish.handler;

import com.pragma.foodcourt.application.dish.dto.response.FindAllDishesResponseDto;

import java.util.List;

public interface IFindAllDishesHandler {

    List<FindAllDishesResponseDto> findAllDish();

}
