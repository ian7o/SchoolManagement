package com.school20.school2.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class TeacherExceptionHandler {
    Error error = new Error();

    @ExceptionHandler(value = {
            TeacherNotFoundException.class
    })
    public ResponseEntity<Error> clientNotFoundException(Exception exception, HttpServletRequest request) {
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        error.setMethod(request.getMethod());
        error.setTimeStamp(new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(value = {
            EmailAlreadyExistsException.class
    })

    public ResponseEntity<Error> hadGeneralErrorException(Exception exception, HttpServletRequest request){
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        error.setMethod(request.getMethod());
        error.setTimeStamp(new Date());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}