package com.dylan.maps.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dylan.maps.exceptions.RoleNotFound;
import com.dylan.maps.exceptions.UserNotFoundException;
import com.dylan.maps.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    
    @ExceptionHandler(RoleNotFound.class)
    public ResponseEntity<?> handleRoleNotFound (RoleNotFound e){

        ErrorResponse roleNotFound = new ErrorResponse(LocalDateTime.now(),"Role not Found: ", e.getMessage() );

        return new ResponseEntity<>(roleNotFound, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound (UserNotFoundException e){

        ErrorResponse userNotFound = new ErrorResponse(LocalDateTime.now(), "User not found: " , e.getMessage());

        return new ResponseEntity<>(userNotFound, HttpStatus.NOT_FOUND);
    }
    
}
