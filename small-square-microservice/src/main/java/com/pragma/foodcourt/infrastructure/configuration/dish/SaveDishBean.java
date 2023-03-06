package com.pragma.foodcourt.infrastructure.configuration.dish;

import com.pragma.foodcourt.domain.api.dish.ISaveDishServicePort;
import com.pragma.foodcourt.domain.spi.dish.ISaveDishPersistencePort;
import com.pragma.foodcourt.domain.usecase.dish.SaveDishUseCase;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish.SaveDishAdapter;
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
    public ISaveDishPersistencePort saveDishPersistencePort() {
        return new SaveDishAdapter(dishRepository, saveDishEntityMapper);
    }

    @Bean
    public ISaveDishServicePort saveDishServicePort() {
        return new SaveDishUseCase(saveDishPersistencePort());
    }
}
