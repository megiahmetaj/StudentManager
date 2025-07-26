package com.example.StudentManager.student_manager.controller;

import com.example.StudentManager.student_manager.dto.request.EnrollmentRequestDTO;
import com.example.StudentManager.student_manager.dto.response.StudentResponseDTO;
import com.example.StudentManager.student_manager.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    public final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<String> enrollStudent(@RequestBody EnrollmentRequestDTO dto){
        enrollmentService.enroll(dto);
        return ResponseEntity.ok("Studenti u regjstrua ne rregull");
    }

    @GetMapping("/{id}/student")
    public List<StudentResponseDTO> getStudentsForCourse(@PathVariable Long id){
        return enrollmentService.getStudentsForCourse(id);
    }
}
