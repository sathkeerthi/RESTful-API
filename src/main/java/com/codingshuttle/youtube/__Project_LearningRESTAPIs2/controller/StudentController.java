package com.codingshuttle.youtube.__Project_LearningRESTAPIs2.controller;

import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.AddStudentRequestDto;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.StudentDto;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.entity.Student;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.repository.StudentRepository;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getAllStudents(@PathVariable Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
