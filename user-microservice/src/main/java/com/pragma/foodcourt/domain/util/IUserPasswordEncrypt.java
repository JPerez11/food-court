package com.pragma.foodcourt.domain.util;

/**
 * Interface to encrypt password
 */
public interface IUserPasswordEncrypt {

    String passwordEncoder(String password);

}
