package com.pragma.foodcourt.infrastructure.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class to obtain authentication credentials.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthCredentials {

    private String email;
    private String password;

}
