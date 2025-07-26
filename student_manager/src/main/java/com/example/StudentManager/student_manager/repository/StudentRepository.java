package com.example.StudentManager.student_manager.repository;

import com.example.StudentManager.student_manager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
