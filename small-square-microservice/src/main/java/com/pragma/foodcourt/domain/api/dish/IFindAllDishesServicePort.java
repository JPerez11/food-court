package com.pragma.foodcourt.domain.api.dish;

import com.pragma.foodcourt.domain.model.DishModel;

import java.util.List;

public interface IFindAllDishesServicePort {

    List<DishModel> findAllDish();

}
