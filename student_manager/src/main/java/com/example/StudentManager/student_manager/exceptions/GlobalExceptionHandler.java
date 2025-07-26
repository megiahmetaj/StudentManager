package com.example.StudentManager.student_manager.exceptions;

// eshte nje mekanizem ne SpringBoot per te trajtuar gabimet ne menyre te qarte
// i kap gabimet ne menyre automatike dhe i trajton secilen

import com.example.StudentManager.student_manager.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //gabimet e validimit i trajton ky exception
    // ne momentin qe ekzekutohet kur ndodh nje gabim validimi (@Email, @Min)
    // kthen mesazhin qe paracaktuar
    @ExceptionHandler
    public ResponseEntity<Map<String, List<String>>> handlerValidationErrors(MethodArgumentNotValidException e) {
        // kthen nje objekt te tipit ResponseEtity ne formen e nje map
        // qe ka si celse nje string -> errors
        // dhe si vlere nje list me string-e -> gabimet e validimit
        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " : " + error.getDefaultMessage())
                .toList();
        Map<String, List<String>> response = new HashMap<>();
        response.put("errors ", errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Rasti kur nuk gjendet studenti
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleStudentNotFound(StudentNotFoundException s){
        Map<String, List<String>> response = new HashMap<>();
        response.put("error", Collections.singletonList(s.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //Rasti kur nuk gjendet kursi
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<Map<String, List<String>>> handleCourseNotFound(CourseNotFoundException c){
        Map<String, List<String>> response = new HashMap<>();
        response.put("error", Collections.singletonList(c.getMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

