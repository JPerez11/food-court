package com.pragma.foodcourt.infrastructure.configuration.dish;

import com.pragma.foodcourt.domain.api.dish.ICreateDishServicePort;
import com.pragma.foodcourt.domain.spi.dish.ICreateDishPersistencePort;
import com.pragma.foodcourt.domain.usecase.dish.CreateDishUseCase;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish.CreateDishAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.ISaveDishEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SaveDishBean {

    private final IDishRepository dishRepository;
    private final ISaveDishEntityMapper saveDishEntityMapper;

    @Bean
    public ICreateDishPersistencePort saveDishPersistencePort() {
        return new CreateDishAdapter(dishRepository, saveDishEntityMapper);
    }

    @Bean
    public ICreateDishServicePort saveDishServicePort() {
        return new CreateDishUseCase(saveDishPersistencePort());
    }
}
