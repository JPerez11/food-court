package com.pragma.foodcourt.domain.spi;

import com.pragma.foodcourt.domain.model.UserModel;

import java.util.List;

/**
 * Interface to persist user data.
 */
public interface IUserPersistencePort {

    UserModel saveUser(UserModel userModel);

    UserModel registerUser(UserModel userModel);

    List<UserModel> getAllUsers();

}
