package com.pragma.foodcourt.application.dish.handler.impl;

import com.pragma.foodcourt.application.dish.dto.response.FindAllDishesResponseDto;
import com.pragma.foodcourt.application.dish.handler.IReadDishHandler;
import com.pragma.foodcourt.application.dish.mapper.IFindAllDishesResponseMapper;
import com.pragma.foodcourt.domain.api.dish.IReadDishServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReadDishHandlerImpl implements IReadDishHandler {

    private final IReadDishServicePort readDishServicePort;
    private final IFindAllDishesResponseMapper findAllDishResponseMapper;

    @Override
    public List<FindAllDishesResponseDto> findAllDish() {
        return findAllDishResponseMapper.dishResponseList(
                readDishServicePort.findAllDish());
    }

    @Override
    public List<FindAllDishesResponseDto> findDishByIdRestaurantOrderByIdCategory(Long id) {
        return findAllDishResponseMapper.dishResponseList(
                readDishServicePort.findDishByIdRestaurantOrderByIdCategory(id));
    }
}
