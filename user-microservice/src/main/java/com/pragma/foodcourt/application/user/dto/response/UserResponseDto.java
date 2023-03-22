package com.pragma.foodcourt.application.user.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Response class to send to user.
 */
@Getter
@Setter
public class UserResponseDto {

    private String name;

    private String lastName;

    private int document;

    private String phone;

    private String email;

}
