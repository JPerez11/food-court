package com.pragma.foodcourt.infrastructure.configuration.dish;

import com.pragma.foodcourt.application.dish.handler.IFindAllDishesHandler;
import com.pragma.foodcourt.domain.api.dish.IFindAllDishesServicePort;
import com.pragma.foodcourt.domain.spi.dish.IFindAllDishesPersistencePort;
import com.pragma.foodcourt.domain.usecase.dish.FindAllDishesUseCase;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.dish.FindAllDishesAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.dish.IFindAllDishesEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IDishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FindAllDishBean {

    private final IDishRepository dishRepository;
    private final IFindAllDishesEntityMapper findAllDishesEntityMapper;

    @Bean
    public IFindAllDishesPersistencePort findAllDishesPersistencePort() {
        return new FindAllDishesAdapter(dishRepository, findAllDishesEntityMapper);
    }

    @Bean
    public IFindAllDishesServicePort findAllDishesServicePort() {
        return new FindAllDishesUseCase(findAllDishesPersistencePort());
    }

}
