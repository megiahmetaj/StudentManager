package com.example.StudentManager.student_manager.controller;

import com.example.StudentManager.student_manager.dto.request.StudentRequestDTO;
import com.example.StudentManager.student_manager.dto.response.CourseResponseDTO;
import com.example.StudentManager.student_manager.dto.response.StudentResponseDTO;
import com.example.StudentManager.student_manager.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponseDTO registerStudent(@RequestBody @Valid StudentRequestDTO dto){
        return studentService.register(dto);
    }

    @GetMapping("/{id}/course")
    public List<CourseResponseDTO> getCourses(@PathVariable Long id){
        return studentService.getCoursesForStudent(id);
    }
}
