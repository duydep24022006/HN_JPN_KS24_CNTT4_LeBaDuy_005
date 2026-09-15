package com.ecommerce.instructorsservice1.repository;

import com.ecommerce.instructorsservice1.entity.Instructors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface instructorsRepository extends JpaRepository<Instructors, Long> {
}
