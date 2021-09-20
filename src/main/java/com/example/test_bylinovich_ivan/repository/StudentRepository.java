package com.example.test_bylinovich_ivan.repository;

import com.example.test_bylinovich_ivan.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
