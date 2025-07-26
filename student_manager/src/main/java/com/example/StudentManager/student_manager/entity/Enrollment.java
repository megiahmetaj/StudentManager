package com.example.StudentManager.student_manager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nje student mund te regjistrohet ne disa kurse
    @ManyToOne(optional = false) // detyron qe fusha nuk mund te jete null
    private Student student;

    // nje kurs mund te kete disa student
    @ManyToOne(optional = false)
    private Course course;
    // @NotBlank eshte vetem per string

    @NotNull(message = "Data e regjstrimit nuk mund te jete bosh")
    private LocalDate enrollmentDate;

    private Double grade;


}
