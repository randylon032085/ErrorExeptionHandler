package com.dylan.maps.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){

        super(message);
    }
    
}
