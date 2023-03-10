package com.pragma.foodcourt.domain.usecase;

import com.pragma.foodcourt.domain.model.RoleModel;
import com.pragma.foodcourt.domain.model.UserModel;
import com.pragma.foodcourt.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserUseCaseTest {

    @Mock
    IUserPersistencePort userPersistencePort;

    @InjectMocks
    UserUseCase userUseCase;

    @Test
    void shouldSaveUser() {
        //Given
        RoleModel roleModel = new RoleModel(1L, "ADMIN", "PLACE MANAGER");
        UserModel userModel = new UserModel(1L, "Name", "LastName", 12345, "12345", "test@gmail.com", "12345", roleModel);

        //When
        when(userPersistencePort.saveUser(userModel)).thenReturn(userModel);
        userUseCase.saveUser(userModel);

        //Then
        verify(userPersistencePort).saveUser(userModel);
    }

}