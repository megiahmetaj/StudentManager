package com.example.StudentManager.student_manager.controller;

import com.example.StudentManager.student_manager.dto.request.CourseRequestDTO;
import com.example.StudentManager.student_manager.dto.response.CourseResponseDTO;
import com.example.StudentManager.student_manager.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseResponseDTO create(@RequestBody @Valid CourseRequestDTO dto){
        return courseService.create(dto);
    }
}
