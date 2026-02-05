package com.dylan.maps.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dylan.maps.model.User;

public interface UserRespository extends JpaRepository<User, Integer> {
  
    Optional<User> findByUsername (String username);
}
