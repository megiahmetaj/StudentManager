package com.example.StudentManager.student_manager.service;

import com.example.StudentManager.student_manager.dto.request.StudentRequestDTO;
import com.example.StudentManager.student_manager.dto.response.CourseResponseDTO;
import com.example.StudentManager.student_manager.dto.response.StudentResponseDTO;
import com.example.StudentManager.student_manager.entity.Course;
import com.example.StudentManager.student_manager.entity.Enrollment;
import com.example.StudentManager.student_manager.entity.Student;
import com.example.StudentManager.student_manager.repository.EnrollmentRepository;
import com.example.StudentManager.student_manager.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final EnrollmentRepository enrollmentRepository;


    public StudentService(StudentRepository studentRepository, EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    //regjistro nje student te ri ne databaze
    // INPUT: nje objekt StudentRequesDTO, qe permban name, email, age
    // output: nje objekt StudentResponseDTO qe i kthen klientit
    public StudentResponseDTO register(StudentRequestDTO dto){
        Student student = new Student(null, dto.getName(), dto.getEmail(), dto.getAge());
        Student saved = studentRepository.save(student);
        return new StudentResponseDTO(saved.getId(), saved.getName(), saved.getEmail(), saved.getAge());
    }

    public List<CourseResponseDTO> getCoursesForStudent(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);
        return enrollments.stream()
                //per cdo regjistrim e merr kursin perkates me e.getCourse
                .map(enrollment -> {
                    Course c = enrollment.getCourse();
                    return new CourseResponseDTO(
                            c.getId(),
                            c.getTitle(),
                            c.getDescription(),
                            c.getCredits()
                    );

                }).toList();
    }
}
