package com.codingshuttle.youtube.__Project_LearningRESTAPIs2.service.impl;

import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.AddStudentRequestDto;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.dto.StudentDto;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.entity.Student;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.repository.StudentRepository;
import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student with the id '" + id + "' doesn't exist in the Database."));
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
            throw new IllegalArgumentException("Student with the id '" + id + "' doesn't exist in the Database.");
        }
        studentRepository.deleteById(id);
        //? If student does not exist, throw illegal exception.
        //? If exists, only then delete
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student with the id '" + id + "' doesn't exist in the Database."));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updateStudentPartial(Long id, Map<String, Object> updateData) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with the id '" + id + "' doesn't exist in the Database."));

        updateData.forEach((field, value) -> {
            switch (field){
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
