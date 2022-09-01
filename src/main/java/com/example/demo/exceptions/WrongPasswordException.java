package com.example.demo.exceptions;



public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String msg) {
        super(msg);
    }
}