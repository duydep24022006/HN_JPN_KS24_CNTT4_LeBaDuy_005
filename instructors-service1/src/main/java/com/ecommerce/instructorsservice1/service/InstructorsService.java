package com.ecommerce.instructorsservice1.service;

import com.ecommerce.instructorsservice1.entity.Instructors;
import com.ecommerce.instructorsservice1.exception.InstructorsNotFoundException;
import com.ecommerce.instructorsservice1.repository.instructorsRepository;
import org.springframework.stereotype.Service;

@Service

public class InstructorsService {
    private final instructorsRepository instructorsRepository;

    public InstructorsService(instructorsRepository instructorsRepository) {
        this.instructorsRepository = instructorsRepository;
    }
    public Instructors getById(Long id) {
        return instructorsRepository.findById(id)
                .orElseThrow(() -> new InstructorsNotFoundException(id));
    }
}
