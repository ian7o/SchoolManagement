package com.schoolManagement.Exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.security.SignatureException;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    ProblemDetail problemDetail = null;


    @ExceptionHandler(value = {
            EmailNotFoundException.class

    })
    public ProblemDetail clientNotFoundException(Exception exception, HttpServletRequest request) {
        problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        problemDetail.setProperty("method", request.getMethod());
        problemDetail.setProperty("time", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(value = {
            EmailAlreadyExistsException.class
    })
    public ProblemDetail infoAlreadyExist(Exception exception, HttpServletRequest request) {
        problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        problemDetail.setProperty("method", request.getMethod());
        problemDetail.setProperty("time", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleSecurityException(Exception exception) {
        switch (exception) {
            case BadCredentialsException badCredentialsException -> {
                problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, exception.getMessage());
                problemDetail.setProperty("description", "The username or password is incorrect");
                return problemDetail;
            }
            case AccountStatusException accountStatusException -> {
                problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
                problemDetail.setProperty("description", "The account is locked");
                return problemDetail;
            }
            case AccessDeniedException accessDeniedException -> {
                problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
                problemDetail.setProperty("description", "You are not authorized to access this resource");
                return problemDetail;
            }
            case SignatureException signatureException -> {
                problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
                problemDetail.setProperty("description", "The JWT signature is invalid");
                return problemDetail;
            }
            case ExpiredJwtException expiredJwtException -> {
                problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
                problemDetail.setProperty("description", "The JWT token has expired");
                return problemDetail;
            }
            case null, default -> {
                problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
                problemDetail.setProperty("description", "Undocumented internal server error.");
                return problemDetail;
            }
        }
    }
}