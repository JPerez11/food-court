package com.pragma.foodcourt.domain.spi.dish;

import com.pragma.foodcourt.domain.model.DishModel;

import java.util.List;

public interface IFindAllDishesPersistencePort {

    List<DishModel> findAllDishes();

}
