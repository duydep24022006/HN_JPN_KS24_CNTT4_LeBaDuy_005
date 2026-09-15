package com.ecommerce.courseservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InstructorNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleInstructorNotFound(InstructorNotFoundException ex) {
        return error(HttpStatus.NOT_FOUND, "Instructor Not Found", ex.getMessage());
    }

    @ExceptionHandler(InstructorServiceUnavailableException.class)
    public ResponseEntity<Map<String, Object>> handleInstructorServiceUnavailable(InstructorServiceUnavailableException ex) {
        return error(HttpStatus.SERVICE_UNAVAILABLE, "Service Unavailable", ex.getMessage());
    }

    private ResponseEntity<Map<String, Object>> error(HttpStatus status, String error, String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", Instant.now().toString());
        body.put("status", status.value());
        body.put("error", error);
        body.put("message", message);
        return ResponseEntity.status(status).body(body);
    }
}
