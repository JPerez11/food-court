package com.pragma.foodcourt.domain.model;

import com.pragma.foodcourt.domain.validation.Validations;

/**
 * Model that represents a user in the application.
 */
public class UserModel {

    /** The user's unique identifier */
    private Long id;

    /** The user's first name */
    private String name;

    /** The user's last name */
    private String lastName;

    /** The user's document number */
    private int document;

    /** The user's phone number */
    private String phone;

    /** The user's email address */
    private String email;

    /** The user's password */
    private String password;

    /** The user's role */
    private RoleModel idRole;

    /** Default constructor */
    public UserModel() {
    }

    /**
     *
     * @param id The user's unique identifier
     * @param name // The user's first name
     * @param lastName // The user's last name
     * @param document // The user's document number
     * @param phone // The user's phone number
     * @param email // The user's email address
     * @param password // The user's password
     * @param idRol // The user's role
     */
    public UserModel(Long id, String name, String lastName, int document, String phone, String email,
                     String password, RoleModel idRol) {
        Validations valid = new Validations();
        this.id = id;
        this.name = valid.emptyStringValidate(name);
        this.lastName = valid.emptyStringValidate(lastName);
        this.document = document;
        this.phone = valid.numberPhoneValidate(valid.emptyStringValidate(phone));
        this.email = valid.emailValidate(valid.emptyStringValidate(email));
        this.password = valid.emptyStringValidate(password);
        this.idRole = idRol;
    }

    /**
     * Returns the unique identifier of the user.
     */
    public Long getId() {
        return id;
    }

    /**
     * Assigns a new unique identifier to the user.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Assigns a new user's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the user's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Assigns a new user's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the user's document.
     */
    public int getDocument() {
        return document;
    }

    /**
     * Assigns a new user's document.
     */
    public void setDocument(int document) {
        this.document = document;
    }

    /**
     * Returns the user's phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Assigns a new user's phone.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns the user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Assigns a new user's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Assigns a new user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the user's role.
     */
    public RoleModel getIdRole() {
        return idRole;
    }

    /**
     * Assigns a new user's role.
     */
    public void setIdRole(RoleModel idRole) {
        this.idRole = idRole;
    }


}
