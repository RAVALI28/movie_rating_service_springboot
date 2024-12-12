package com.ravali.springboot.Exception;


public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}
