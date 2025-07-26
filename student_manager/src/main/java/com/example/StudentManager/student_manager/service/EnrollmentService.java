package com.example.StudentManager.student_manager.service;

import com.example.StudentManager.student_manager.dto.request.EnrollmentRequestDTO;
import com.example.StudentManager.student_manager.dto.response.StudentResponseDTO;
import com.example.StudentManager.student_manager.entity.Course;
import com.example.StudentManager.student_manager.entity.Enrollment;
import com.example.StudentManager.student_manager.entity.Student;
import com.example.StudentManager.student_manager.repository.CourseRepository;
import com.example.StudentManager.student_manager.repository.EnrollmentRepository;
import com.example.StudentManager.student_manager.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository, CourseRepository courseRepository, StudentRepository studentRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void enroll(EnrollmentRequestDTO dto){
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Studenti nuk ekziston"));
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Kursi nuk ekziston"));
        Enrollment enrollmet = new Enrollment();
        enrollmet.setStudent(student);
        enrollmet.setCourse(course);
        enrollmet.setEnrollmentDate(LocalDate.now());

        //pasi e krijova objektin regjstrim i bej save ne databaze
        enrollmentRepository.save(enrollmet);
    }

    public List<StudentResponseDTO> getStudentsForCourse(Long courseId){
        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(courseId);
        return enrollments.stream().map(enrollment -> {
            Student s = enrollment.getStudent();
            return new StudentResponseDTO(
                    s.getId(),
                    s.getName(),
                    s.getEmail(),
                    s.getAge()
            );
        }).toList();
    }
}
