package com.pragma.foodcourt.domain.api;

import com.pragma.foodcourt.domain.model.UserModel;

import java.util.List;

/**
 * Interface to provide the user service.
 */
public interface IUserServicePort {

    void saveUser(UserModel userModel);

    void registerUser(UserModel userModel);

    List<UserModel> getAllUsers();

}
