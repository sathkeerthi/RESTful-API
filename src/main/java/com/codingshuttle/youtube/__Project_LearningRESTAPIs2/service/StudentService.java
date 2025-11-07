package com.codingshuttle.youtube.__Project_LearningRESTAPIs2.service;

import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);
}
