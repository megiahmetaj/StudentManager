package com.example.StudentManager.student_manager.repository;

import com.example.StudentManager.student_manager.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
