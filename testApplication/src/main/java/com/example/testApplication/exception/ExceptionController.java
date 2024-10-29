package com.example.testApplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(StudentDoesNotExistException.class)
    public ResponseEntity<String> interceptStudentException(StudentDoesNotExistException existException){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(existException.getMessage());
    }

    @ExceptionHandler(UnavailableNameException.class)
    public ResponseEntity<String> interceptStudentException(UnavailableNameException nameException){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(nameException.getMessage());
    }
}
