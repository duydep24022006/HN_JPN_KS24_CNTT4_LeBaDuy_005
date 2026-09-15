package com.ecommerce.courseservice.controler;



import com.ecommerce.courseservice.entity.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ecommerce.courseservice.dto.CreateCourseRequest;
import com.ecommerce.courseservice.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseControler {
    private CourseService courseService;

    public CourseControler(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }


    @PostMapping()
    public ResponseEntity<Course> create(@RequestBody CreateCourseRequest request) {
        Course course = courseService.createCourse(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }
}
