package com.dylan.maps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dylan.maps.dto.role.request.CreateRoleRequest;
import com.dylan.maps.dto.role.response.RoleResponse;
import com.dylan.maps.exceptions.RoleNotFound;
import com.dylan.maps.model.Role;
import com.dylan.maps.repositories.RoleRepositories;
import com.dylan.maps.util.RoleMapstruct;

@Service
public class RoleService {

    @Autowired
    private RoleRepositories roleRepositories;

    @Autowired
    private RoleMapstruct roleMapstruct;

    @Transactional(readOnly = true)
    public Page<RoleResponse> getAllRole(Pageable pageable) {

        return roleRepositories.findAll(pageable).map(roleMapstruct::toDto);
    }

    @Transactional
    public RoleResponse getRoleById(int id) {

        Role role = roleRepositories.findById(id).orElseThrow(() -> new RoleNotFound("Role not found: " + id));

        return roleMapstruct.toDto(role);

    }

    @Transactional
    public RoleResponse createRole(CreateRoleRequest createRoleRequest) {

        Role role = roleMapstruct.toEntity(createRoleRequest);

        // role.setName("it");

        Role saveRole = roleRepositories.save(role);

        return roleMapstruct.toDto(saveRole);

    }

    @Transactional
    public RoleResponse getRoleByRolename(String rolename) {

        Role role = roleRepositories.findByname(rolename)
                .orElseThrow(() -> new RoleNotFound("Role not found: " + rolename));
        return roleMapstruct.toDto(role);

    }

}
