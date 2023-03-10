package com.pragma.foodcourt.domain.spi;

import com.pragma.foodcourt.domain.model.UserModel;

import java.util.List;

public interface IUserPersistencePort {

    UserModel saveUser(UserModel userModel);

    void registerUser(UserModel userModel);

    List<UserModel> getAllUsers();

}
