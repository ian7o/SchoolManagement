package com.school20.school2.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class TeacherExceptionHandler {
    Error error = new Error();
    ProblemDetail problemDetail = null;

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

    public ResponseEntity<Error> infoAlreadyExist(Exception exception, HttpServletRequest request) {
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        error.setMethod(request.getMethod());
        error.setTimeStamp(new Date());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    //vou substituir por isso pois vai dar o mesmo resultado e é uma classe Já existente
//    private ResponseEntity<ProblemDetail> infoAlreadyExist(Exception exception, HttpServletRequest request){
//        problemDetail.setTitle("Teacher email already exit");
//        problemDetail.setStatus(HttpStatus.BAD_REQUEST);
//        problemDetail.setDetail(exception.getMessage());
//        problemDetail.setProperty("method", request.getMethod());
//        problemDetail.setProperty("uri", request.getRequestURI());
//        problemDetail.setProperty("time", Instant.now());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetail);
//    }


}