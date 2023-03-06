package com.pragma.foodcourt.domain.model;

import com.pragma.foodcourt.domain.exception.DomainException;
import com.pragma.foodcourt.domain.validation.Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserModel {

    private Long id;

    private String name;

    private String lastName;

    private int nit;

    private String phone;

    private String email;

    private String password;

    private RoleModel idRole;

    public UserModel() {
    }

    public UserModel(Long id, String name, String lastName, int nit, String phone, String email,
                     String password, RoleModel idRol) {
        Validations valid = new Validations();
        this.id = id;
        this.name = valid.emptyStringValidate(name);
        this.lastName = valid.emptyStringValidate(lastName);
        this.nit = nit;
        this.phone = valid.numberPhoneValidate(valid.emptyStringValidate(phone));
        this.email = valid.emailValidate(valid.emptyStringValidate(email));
        this.password = valid.emptyStringValidate(password);
        this.idRole = idRol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleModel getIdRole() {
        return idRole;
    }

    public void setIdRole(RoleModel idRole) {
        this.idRole = idRole;
    }


}
