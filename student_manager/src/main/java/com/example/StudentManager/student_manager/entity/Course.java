package com.example.StudentManager.student_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titulli nuk duhet te jete bosh")
    private String title;

    @NotBlank(message = "Pershkrimi nuk duhet te jete bosh")
    private String description;

    @NotNull(message = "Kreditet nuk duhet te jene bosh")
    @Min(value = 1, message = "Kreditet duhet te jene pakten se 1")
    private int credits;


}
