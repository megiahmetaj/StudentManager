package com.example.StudentManager.student_manager.controller;

import com.example.StudentManager.student_manager.dto.request.CourseRequestDTO;
import com.example.StudentManager.student_manager.dto.response.CourseResponseDTO;
import com.example.StudentManager.student_manager.entity.Course;
import com.example.StudentManager.student_manager.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/credits")
    public List<Course> getCoursesWithMinCredits(@RequestParam int min) {
        return courseService.findByCreditsGreaterThan(min);
    }
}
