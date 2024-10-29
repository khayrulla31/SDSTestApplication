package com.example.testApplication.exception;

public class UnavailableNameException extends RuntimeException{
    private final String exceptionMessage = "This name is already taken!";
    public UnavailableNameException() {
    }
    public UnavailableNameException(String message) {
        super(message);
    }
}
