package com.pragma.foodcourt.domain.usecase.dish;

import com.pragma.foodcourt.domain.api.dish.ISaveDishServicePort;
import com.pragma.foodcourt.domain.model.DishModel;
import com.pragma.foodcourt.domain.spi.dish.ISaveDishPersistencePort;

public class SaveDishUseCase implements ISaveDishServicePort {

    private final ISaveDishPersistencePort saveDishPersistencePost;

    public SaveDishUseCase(ISaveDishPersistencePort saveDishPersistencePost) {
        this.saveDishPersistencePost = saveDishPersistencePost;
    }

    @Override
    public void saveDish(DishModel dishModel) {
        saveDishPersistencePost.saveDish(dishModel);
    }
}
