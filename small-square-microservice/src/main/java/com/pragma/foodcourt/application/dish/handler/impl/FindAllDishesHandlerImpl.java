package com.pragma.foodcourt.application.dish.handler.impl;

import com.pragma.foodcourt.application.dish.dto.response.FindAllDishesResponseDto;
import com.pragma.foodcourt.application.dish.handler.IFindAllDishesHandler;
import com.pragma.foodcourt.application.dish.mapper.IFindAllDishesResponseMapper;
import com.pragma.foodcourt.domain.api.dish.IFindAllDishesServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FindAllDishesHandlerImpl implements IFindAllDishesHandler {

    private final IFindAllDishesServicePort findAllDishServicePort;
    private final IFindAllDishesResponseMapper findAllDishResponseMapper;

    @Override
    public List<FindAllDishesResponseDto> findAllDish() {
        return findAllDishResponseMapper.dishResponseList(findAllDishServicePort.findAllDish());
    }
}
