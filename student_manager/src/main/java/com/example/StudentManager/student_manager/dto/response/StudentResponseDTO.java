package com.example.StudentManager.student_manager.dto.response;

// perdoret per te kthyer te dhenat nga backend te klienti
// output per nje get ose post
// per te kontrolluar cfare i dergojme klientit
// per te dhene pergjigjen ne nje forem me te paster


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {
    private Long id;

    private String name;

    private String email;

    private int age;

}
