package com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.ISaveDishPersistencePort;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.ISaveDishEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveDishAdapter implements ISaveDishPersistencePort {

    private final IDishRepository dishRepository;
    private final ISaveDishEntityMapper saveDishEntityMapper;

    @Override
    public void saveDish(DishModel dishModel) {
        dishRepository.save(saveDishEntityMapper.toDishEntity(dishModel));
    }

}
