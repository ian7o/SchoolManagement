package com.schoolManagement.Exceptions;

public class StudentEmailNotFoundException extends RuntimeException {
    public StudentEmailNotFoundException(String message) {
        super(message);
    }
}
