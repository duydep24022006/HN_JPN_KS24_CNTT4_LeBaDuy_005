package com.ecommerce.instructorsservice1.controler;

import com.ecommerce.instructorsservice1.entity.Instructors;
import com.ecommerce.instructorsservice1.service.InstructorsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructors")
public class InstructorControler {
    private final InstructorsService instructorService;
    public InstructorControler(InstructorsService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructors> getInstructorById(@PathVariable Long id) {
        return ResponseEntity.ok(instructorService.getById(id));
    }
}
