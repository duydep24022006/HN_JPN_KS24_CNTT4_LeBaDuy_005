package com.ecommerce.courseservice.service;

import com.ecommerce.courseservice.client.InstructorClient;
import com.ecommerce.courseservice.dto.CreateCourseRequest;
import com.ecommerce.courseservice.entity.Course;
import com.ecommerce.courseservice.exception.InstructorNotFoundException;
import com.ecommerce.courseservice.exception.InstructorServiceUnavailableException;
import com.ecommerce.courseservice.repository.CourseRepository;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorClient instructorClient;

    public CourseService(CourseRepository courseRepository, InstructorClient instructorClient) {
        this.courseRepository = courseRepository;
        this.instructorClient = instructorClient;
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course createCourse(CreateCourseRequest course) {
        verifyCategoryExists(course.instructorId());
        Course newCourse = new Course(
                null,
                course.name(),
                course.description(),
                course.instructorId()
        );
        return courseRepository.save(newCourse);
    }

    private void verifyCategoryExists(Long categoryId) {
        try {
            instructorClient.getInstructorById(categoryId);
        } catch (FeignException.NotFound ex) {
            throw new InstructorNotFoundException(categoryId);
        } catch (FeignException ex) {
            throw new InstructorServiceUnavailableException();
        }
    }
}
