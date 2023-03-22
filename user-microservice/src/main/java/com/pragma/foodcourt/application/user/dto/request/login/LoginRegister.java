package com.pragma.foodcourt.application.user.dto.request.login;

import lombok.Getter;
import lombok.Setter;

/**
 * Request class to register the user.
 */
@Getter
@Setter
public class LoginRegister {

    private String name;
    private String lastName;
    private int document;
    private String email;
    private String phone;
    private String password;

}
