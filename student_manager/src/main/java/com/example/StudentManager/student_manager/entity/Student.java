package com.example.StudentManager.student_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Emri nuk mund te jete bosh")
    private String name;

    @NotBlank(message = "Emaili nuk mund te jete bosh")
    @Email(message = "Email-i duhet te jete valid")
    private String email;

    //siguron qe mosha min duhet te jete 16
    @Min(value = 16, message = "Mosha duhet te jete te pakten 16")
    private int age;

}
