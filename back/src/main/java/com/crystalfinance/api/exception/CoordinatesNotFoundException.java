package com.crystalfinance.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CoordinatesNotFoundException extends RuntimeException{
    public CoordinatesNotFoundException(String message){
        super(message);
    }
}
