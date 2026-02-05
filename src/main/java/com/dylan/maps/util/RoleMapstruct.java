package com.dylan.maps.util;

import org.mapstruct.Mapper;

import com.dylan.maps.dto.role.request.CreateRoleRequest;
import com.dylan.maps.dto.role.response.RoleResponse;
import com.dylan.maps.model.Role;

@Mapper(componentModel="spring")
public interface RoleMapstruct {


    RoleResponse toDto(Role role);
    

    Role toEntity (CreateRoleRequest createRoleRequest);
}
