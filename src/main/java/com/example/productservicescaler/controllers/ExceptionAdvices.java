package com.example.productservicescaler.controllers;

import com.example.productservicescaler.exceptions.WrongIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(WrongIdException.class)
    public ResponseEntity<String> wongIdExceptionHandler(){
        return new ResponseEntity<>("Wrong Id is provided.", HttpStatus.NOT_FOUND);
    }
}
