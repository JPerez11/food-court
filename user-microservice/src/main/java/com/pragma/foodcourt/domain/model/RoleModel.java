package com.pragma.foodcourt.domain.model;

/**
 * Model that represents a role in the application.
 */
public class RoleModel {

    /** The role's unique identifier */
    private Long id;
    /** The role's name */
    private String name;
    /** The role's description */
    private String description;

    /** Default constructor */
    public RoleModel() {
    }

    /**
     *
     * @param id The role's unique identifier
     * @param name The role's name
     * @param description The role's description
     */
    public RoleModel(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
     * Returns the role's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Assigns a new role's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the role's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Assigns a new role's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
