package com.example.StudentManager.student_manager.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Kjo klase perdoret per te marr te dhena nga klienti (input) kur krijon
// ose perditeson nje studnet permes nje kerkese http(post ose put)
// per te kontrolluar cfare te dhenash lejon app qe te vijne nga jashte
// per te vendosur validime @NotBlank ose @Email
// per te mos lejuar qe perdoruesi te dergoje te dhena te padeshiruara

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {

    @NotBlank(message = "Emri nuk lihet bosh")
    private String name;

    @Email(message = "Email duhet te jete valid")
    @NotBlank(message = "Email nk lihet bosh")
    private String email;

    @Min(value = 16, message = "Mosha jo me e vogel se 16")
    private int age;
}
