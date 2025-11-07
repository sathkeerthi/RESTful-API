package com.codingshuttle.youtube.__Project_LearningRESTAPIs2.repository;

import com.codingshuttle.youtube.__Project_LearningRESTAPIs2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
