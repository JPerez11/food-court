package com.pragma.foodcourt.domain.spi.dish;

import com.pragma.foodcourt.domain.model.DishModel;

public interface ICreateDishPersistencePort {

    void saveDish(DishModel dishModel);

}
