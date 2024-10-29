package com.example.testApplication.exception;

public class StudentDoesNotExistException extends RuntimeException{
    private final String message = "Student doesn't exist!";

    public StudentDoesNotExistException() {
    }
    public StudentDoesNotExistException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
