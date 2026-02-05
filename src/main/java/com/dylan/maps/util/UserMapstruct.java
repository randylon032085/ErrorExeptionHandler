package com.dylan.maps.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dylan.maps.dto.user.response.UserResponse;
import com.dylan.maps.model.User;

@Mapper(componentModel="spring")
public interface UserMapstruct {
    
    @Mapping(target="x", source="role.name")
    UserResponse toDto(User user);

    
}
