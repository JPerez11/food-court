package com.pragma.foodcourt.infrastructure.action;

import com.pragma.foodcourt.infrastructure.output.jpa.entity.RoleEntity;
import com.pragma.foodcourt.infrastructure.output.jpa.repository.IRoleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Actions {

    private Actions() {}

    public static RoleEntity getRoleWithAuthentication(IRoleRepository roleRepository) {
        List<RoleEntity> roleEntities = roleRepository.findAll();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        String username = userDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        String authority = "ROOT";
        for (GrantedAuthority auth :
                authorities) {
            authority = auth.getAuthority();
        }
        for (RoleEntity rol :
                roleEntities) {
            if (authority.equalsIgnoreCase("CUSTOMER")) {
                return roleRepository.findByName("CUSTOMER");
            } else if (authority.equalsIgnoreCase(rol.getName())) {
                Long id = rol.getId() + 1;
                return roleRepository.findById(id).orElse(null);
            } else if (authority.equalsIgnoreCase("ROOT")) {
                return roleRepository.findByName("ADMIN");
            }
        }
        return null;

    }
}
