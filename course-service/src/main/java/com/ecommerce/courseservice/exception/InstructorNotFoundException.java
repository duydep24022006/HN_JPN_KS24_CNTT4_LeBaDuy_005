package com.ecommerce.courseservice.exception;

public class InstructorNotFoundException extends RuntimeException {
    public InstructorNotFoundException(Long categoryId) {
        super("Instructor with id " + categoryId + " does not exist");
    }
}
