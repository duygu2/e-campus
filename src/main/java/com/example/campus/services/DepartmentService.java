package com.example.campus.services;

import com.example.campus.model.Department;
import com.example.campus.repository.DepartmentRepository;
import com.example.campus.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;

    public Department addDepartment(Long id, Department department) {
        department.setFaculty(facultyRepository.findById(id).get());
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).get();
    }

    public Department getAllDepartment() {
        return (Department) departmentRepository.findAll();
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Long id, Department department) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        departmentOptional.ifPresent(department1 -> {
            department1.setName(department.getName());
            department1.setCourses(department.getCourses());
            departmentRepository.save(department1);
        });
        return departmentOptional.orElse(new Department());
    }

}
