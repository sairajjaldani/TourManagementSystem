package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {

	    @ExceptionHandler(value = UserAlreadyExistException.class)
	    public ResponseEntity<String> handleUserAlreadyExist(Exception e) {
	        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
	        return responseEntity;
	    }

	    @ExceptionHandler(value = WrongPasswordException.class)
	    public ResponseEntity<String> handleWrongPassword(Exception e) {
	        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
	        return responseEntity;
	    }
    
}