package com.example.student_crud.repository;

import com.example.student_crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Marks this as a data access layer
public interface StudentRepository extends JpaRepository<Student, Long> {
    // JpaRepository provides CRUD methods automatically
}
