package com.pragma.foodcourt.domain.validation;

import com.pragma.foodcourt.domain.exception.DomainException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationRestaurant {
    private static final String VALID_PHONE = "^\\+?\\d+$";

    private ValidationRestaurant() {}

    public static String emptyValidate(String data) {
        if(data.isEmpty()) {
            throw new DomainException("The field cannot empty");
        }
        return data;
    }

    public static int emptyValidate(int data) {
        if(data == 0) {
            throw new DomainException("The field cannot empty");
        }
        return data;
    }

    public static String numberPhoneValidate(String phone) {
        Pattern pattern = Pattern
                .compile(VALID_PHONE);
        Matcher mather = pattern.matcher(phone);
        if(!mather.find()) {
            throw new DomainException("The phone format is invalid");
        }
        if(phone.length() > 13) {
            throw new DomainException("The content of the phone must contain a maximum of 13 characters");
        }
        return phone;
    }
}
