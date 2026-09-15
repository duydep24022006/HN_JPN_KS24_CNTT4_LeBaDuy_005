package com.ecommerce.courseservice.exception;

public class InstructorServiceUnavailableException extends RuntimeException {
    public InstructorServiceUnavailableException() {
        super("Instructor service is unavailable");
    }
}
