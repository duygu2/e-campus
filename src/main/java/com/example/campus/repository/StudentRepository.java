package com.example.campus.repository;

import com.example.campus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    //User findByUsername(Long username);
}
