package com.example.StudentManager.student_manager.service;

import com.example.StudentManager.student_manager.dto.request.CourseRequestDTO;
import com.example.StudentManager.student_manager.dto.response.CourseResponseDTO;
import com.example.StudentManager.student_manager.entity.Course;
import com.example.StudentManager.student_manager.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // siguron qe i gjithe operacioni i methods te ekzekutohet brenda nje transaksioni te vetem
    // nese ndonje nje gabim ne ndonje pjese te metodes psh te save automatikisht
    // anullohet i gjithe veprimi - behet rollback ne databaze
    // perdoret per te garantuar integitetin  e te dhenave
    @Transactional
    public CourseResponseDTO create(CourseRequestDTO dto){
        Course course = new Course(null, dto.getTitle(), dto.getDescription(), dto.getCredits());
        Course saved = courseRepository.save(course);
        return new CourseResponseDTO(saved.getId(), saved.getTitle(), saved.getDescription(), saved.getCredits());
    }

}
