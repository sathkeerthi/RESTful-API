package com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto;
//? Purpose of creation of this DTO?
//? Because we don't want users to send 'id'.
//? Our DB has automatic ID generation through GenerationType.IDENTITY
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddStudentRequestDto {
    @NotBlank (message = "Name is required")
    @Size(min = 3, max = 30, message = "Name length should be between 3 and 30 characters")
    private String name;

    @Email
    @NotBlank (message = "Email is required")
    private String email;

}
