package com.pragma.foodcourt.infrastructure.action;

import com.pragma.foodcourt.infrastructure.output.jpa.entity.RoleEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRoleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Class to determine the role based on the logged-in user.
 */
public class Actions {

    private Actions() {}

    /**
     * Method to generate the user role.
     * @param roleRepository Repository to fetch the roles.
     */
    public static RoleEntity getRoleWithAuthentication(IRoleRepository roleRepository) {
        //Get the roles from database
        List<RoleEntity> roleEntities = roleRepository.findAll();
        //Get the session context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //The role is extracted from the session
        String role = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElseThrow( () -> new UsernameNotFoundException("No exist rol on database."));
        for (RoleEntity rol :
                roleEntities) {
            if (rol.getName().equalsIgnoreCase(role)) {
                //Return the next role.
                return roleRepository.findById(rol.getId() + 1)
                        .orElseThrow(() -> new UsernameNotFoundException("No exist rol on database."));
            } else if (rol.getName().equalsIgnoreCase("CUSTOMER")) {
                return null;
            }
        }
        return null;

    }
}
