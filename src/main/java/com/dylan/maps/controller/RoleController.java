package com.dylan.maps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dylan.maps.dto.role.request.CreateRoleRequest;
import com.dylan.maps.dto.role.response.RoleResponse;
import com.dylan.maps.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping()
    public ResponseEntity<Page<RoleResponse>> getAllRole(Pageable pageable) {

        return ResponseEntity.ok(roleService.getAllRole(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRoleById(@PathVariable int id) {

        return new ResponseEntity<>(roleService.getRoleById(id), HttpStatus.OK);

    }

    @GetMapping("name/{name}")
    public ResponseEntity<RoleResponse> getRoleByName(@PathVariable String name) {

        return new ResponseEntity<>(roleService.getRoleByRolename(name), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<RoleResponse> createRole(@Valid @RequestBody CreateRoleRequest createRoleRequest) {

        RoleResponse createNewRole = roleService.createRole(createRoleRequest);

        // return ResponseEntity.ok(createNewRole);
        // return ResponseEntity.ok(createNewRole);

        return new ResponseEntity<>(createNewRole, HttpStatus.CREATED);
    }

}
