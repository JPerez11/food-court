package com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.IFindAllDishesPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.IFindAllDishesEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindAllDishesAdapter implements IFindAllDishesPersistencePort {

    private final IDishRepository dishRepository;
    private final IFindAllDishesEntityMapper findAllDishEntityMapper;

    @Override
    public List<DishModel> findAllDishes() {
        List<DishEntity> dishEntityList = dishRepository.findAll();

        if(dishEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return findAllDishEntityMapper.toDishModelList(dishEntityList);
    }
}
