package com.ecommerce.instructorsservice1.exception;

public class InstructorsNotFoundException extends RuntimeException {
    public InstructorsNotFoundException(Long id) {
        super("Instructor with id " + id + " does not exist");
    }
}
