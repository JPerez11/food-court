package com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish;

import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.IReadDishPersistencePort;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.DishEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.entity.RestaurantEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.IFindAllDishesEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRestaurantRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ReadDishAdapter implements IReadDishPersistencePort {

    private final IDishRepository dishRepository;
    private final IRestaurantRepository restaurantRepository;
    private final IFindAllDishesEntityMapper findAllDishEntityMapper;

    @Override
    public List<DishModel> findAllDishes() {
        List<DishEntity> dishEntityList = dishRepository.findAll();

        if(dishEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return findAllDishEntityMapper.toDishModelList(dishEntityList);
    }

    @Override
    public List<DishModel> findDishByIdRestaurantOrderByIdCategory(Long id) {
        RestaurantEntity restaurantEntity = restaurantRepository
                .findById(id).orElseThrow( () -> new IllegalArgumentException("The restaurant id doesn't exist."));
        List<DishEntity> dishEntityList = dishRepository.findDishByIdRestaurantOrderByIdCategory(restaurantEntity);

        if(dishEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return findAllDishEntityMapper.toDishModelList(dishEntityList);
    }
}
