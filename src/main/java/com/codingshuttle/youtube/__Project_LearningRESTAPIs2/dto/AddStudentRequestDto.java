package com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto;
//? Purpose of creation of this DTO?
//? Because we don't want users to send 'id'.
//? Our DB has automatic ID generation through GenerationType.IDENTITY
import lombok.Data;

@Data
public class AddStudentRequestDto {
    private String name;
    private String email;
}
