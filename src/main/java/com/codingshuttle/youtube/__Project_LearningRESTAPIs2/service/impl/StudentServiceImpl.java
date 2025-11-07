package com.codingshuttle.youtube.__Project_LearningRESTAPIs2.service.impl;

import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.config.MapperConfig;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.AddStudentRequestDto;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.StudentDto;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.entity.Student;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.repository.StudentRepository;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
//        return studentRepository.findAll().stream()
//                .map(student -> new StudentDto(student.getId(), student.getName()))
//                .toList();

        //? Using ModelMapper.map to achieve mapping, instead of constructor passing
        return studentRepository.findAll().stream()
                .map(student -> new ModelMapper().map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return new ModelMapper().map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student with the id " + id + " doesn't exist in the Database");
        }
        studentRepository.deleteById(id);
        //? If student does not exist, throw illegal exception.
        //? If exists, only then delete
    }
}
