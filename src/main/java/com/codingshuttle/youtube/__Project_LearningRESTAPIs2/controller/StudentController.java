package com.codingshuttle.youtube.__Project_LearningRESTAPIs2.controller;

import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.StudentDto;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.entity.Student;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.repository.StudentRepository;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDto getAllStudents(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
