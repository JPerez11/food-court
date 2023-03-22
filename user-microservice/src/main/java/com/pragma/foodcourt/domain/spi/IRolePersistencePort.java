package com.pragma.foodcourt.domain.spi;

import com.pragma.foodcourt.domain.model.RoleModel;

import java.util.List;

/**
 * Interface to persist role data.
 */
public interface IRolePersistencePort {

    List<RoleModel> getAllRoles();

}
