package com.dylan.maps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dylan.maps.dto.user.response.UserResponse;
import com.dylan.maps.exceptions.UserNotFoundException;
import com.dylan.maps.model.User;
import com.dylan.maps.repositories.UserRespository;
import com.dylan.maps.util.UserMapstruct;

@Service
public class UserService {

    @Autowired
    private UserRespository userRepo;

    @Autowired
    private UserMapstruct userMapstruct;

    @Transactional(readOnly=true)
    public Page<UserResponse> getAllUser (Pageable pageable){

        return userRepo.findAll(pageable).map(userMapstruct::toDto);
    }
    
    @Transactional
    public UserResponse userGetById(int id){

        User user = userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User not found: "+ id));
        // user.setFirstname("maricel");

        // System.out.println("MY PASSWORD IS: " + user.getPassword());
        return userMapstruct.toDto(user);

    }

    @Transactional
    public UserResponse userGetByUsername(String username){

        User user = userRepo.findByUsername(username).orElseThrow(()-> new UserNotFoundException("User not found: "+ username));


        return  userMapstruct.toDto(user);

    }
   
}
