package com.pragma.foodcourt.infrastructure.configuration;

import com.pragma.foodcourt.domain.api.IUserServicePort;
import com.pragma.foodcourt.domain.spi.IUserPersistencePort;
import com.pragma.foodcourt.domain.usecase.UserUseCase;
import com.pragma.foodcourt.domain.util.IUserPasswordEncrypt;
import com.pragma.foodcourt.infrastructure.impl.UserPasswordEncryptImpl;
import com.pragma.foodcourt.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.pragma.foodcourt.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository objectRepository;
    private final IUserEntityMapper objectEntityMapper;
    private final PasswordEncoder encoder;

    @Bean
    public IUserPersistencePort objectPersistencePort() {
        return new UserJpaAdapter(objectRepository, objectEntityMapper);
    }

    @Bean
    public IUserServicePort objectServicePort() {
        return new UserUseCase(objectPersistencePort());
    }

    @Bean
    public IUserPasswordEncrypt passwordEncrypt() {
        return new UserPasswordEncryptImpl(encoder);
    }
}