package com.dylan.maps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dylan.maps.dto.user.response.UserResponse;
import com.dylan.maps.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAllUser (Pageable pageable){

        return ResponseEntity.ok(userService.getAllUser(pageable));

    }


    @GetMapping("/test")
    public ResponseEntity<?> sample(){
        // return ResponseEntity.ok("HEY!");
        return new ResponseEntity<>("HEY!",HttpStatus.NOT_FOUND);

    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById (@PathVariable int id){

        return new ResponseEntity<>(userService.userGetById(id), HttpStatus.OK);
    }

    @GetMapping("/get-username/{username}")
    public ResponseEntity<?> getUserByUsername (@PathVariable String username){

        return new ResponseEntity<>(userService.userGetByUsername(username), HttpStatus.OK);
    }
    

    
    
}
