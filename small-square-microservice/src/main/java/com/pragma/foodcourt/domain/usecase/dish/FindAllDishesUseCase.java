package com.pragma.foodcourt.domain.usecase.dish;

import com.pragma.foodcourt.domain.api.dish.IFindAllDishesServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.IFindAllDishesPersistencePort;

import java.util.List;

public class FindAllDishesUseCase implements IFindAllDishesServicePort {

    private final IFindAllDishesPersistencePort findAllDishesPersistencePort;

    public FindAllDishesUseCase(IFindAllDishesPersistencePort findAllDishesPersistencePort) {
        this.findAllDishesPersistencePort = findAllDishesPersistencePort;
    }

    @Override
    public List<DishModel> findAllDish() {
        return findAllDishesPersistencePort.findAllDishes();
    }
}
