package com.pragma.foodcourt.domain.api;

import com.pragma.foodcourt.domain.model.RoleModel;

import java.util.List;

/**
 * Interface to provide the role service.
 */
public interface IRoleServicePort {

    List<RoleModel> getAllRoles();

}
