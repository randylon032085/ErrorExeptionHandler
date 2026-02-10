package com.dylan.maps.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dylan.maps.model.Role;

public interface RoleRepositories extends JpaRepository<Role, Integer> {

    Optional<Role> findByname(String rolename);

}
