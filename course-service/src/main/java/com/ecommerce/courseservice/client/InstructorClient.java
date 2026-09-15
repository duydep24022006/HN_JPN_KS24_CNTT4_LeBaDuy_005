package com.ecommerce.courseservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-service")
public interface InstructorClient {
    @GetMapping("/api/instructors/{id}")
    InstructorResponse getInstructorById(@PathVariable("id") Long id);

}
