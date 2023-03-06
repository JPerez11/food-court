package com.pragma.foodcourt.application.dish.handler.impl;

import com.pragma.foodcourt.application.dish.dto.request.SaveDishRequestDto;
import com.pragma.foodcourt.application.dish.handler.ISaveDishHandler;
import com.pragma.foodcourt.application.dish.mapper.ISaveDishRequestMapper;
import com.pragma.foodcourt.domain.api.dish.ISaveDishServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class SaveDishHandlerImpl implements ISaveDishHandler {

    private final ISaveDishServicePort saveDishServicePort;
    private final ISaveDishRequestMapper saveDishRequestMapper;

    @Override
    public void saveDish(SaveDishRequestDto saveDishRequestDto) {
        DishModel dishModel = saveDishRequestMapper.toDishModel(saveDishRequestDto);

        saveDishServicePort.saveDish(dishModel);
    }
}
