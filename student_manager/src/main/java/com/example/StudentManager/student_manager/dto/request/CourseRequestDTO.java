package com.example.StudentManager.student_manager.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @Min(1)
    private int credits;
}
