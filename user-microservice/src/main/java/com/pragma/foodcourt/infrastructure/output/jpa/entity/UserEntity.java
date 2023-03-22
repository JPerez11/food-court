package com.pragma.foodcourt.infrastructure.output.jpa.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity that represents a user in the database.
 */
@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

    /** The user's unique identifier */
    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The user's first name */
    @Column(name = "first_name", length = 50, nullable = false)
    private String name;

    /** The user's last name */
    @Column(name ="last_name", length = 50, nullable = false)
    private String lastName;

    /** The user's document number */
    @Column(length = 20, nullable = false, unique = true)
    private int document;

    /** The user's email address */
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    /** The user's phone number */
    @Column(length = 13, nullable = false)
    private String phone;

    /** The user's password */
    @Column(nullable = false)
    private String password;

    /** The user's role */
    @ManyToOne
    @JoinColumn(name = "id_role", nullable = false)
    private RoleEntity idRole;


}
