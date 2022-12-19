package com.example.campus.repository;

import com.example.campus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Collection<Student> findAllByDepartmentId(Long id);
    //User findByUsername(Long username);
}
