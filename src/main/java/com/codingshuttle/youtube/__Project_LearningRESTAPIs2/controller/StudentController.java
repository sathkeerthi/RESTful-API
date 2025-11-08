package com.codingshuttle.youtube.__Project_LearningRESTAPIs2.controller;

import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.AddStudentRequestDto;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.StudentDto;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

//? PUT - To change complete row by taking ID as reference
//? PATCH - To do partial changes in a row

    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDto));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudentPartial(@PathVariable Long id, @RequestBody Map<String, Object> updateData){
        return ResponseEntity.ok(studentService.updateStudentPartial(id, updateData));
    }
}
