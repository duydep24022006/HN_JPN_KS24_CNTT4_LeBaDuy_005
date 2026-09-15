package com.ecommerce.courseservice.dto;

public record CreateCourseRequest(
        String name,
        String description,
        Long instructorId
) {
}
