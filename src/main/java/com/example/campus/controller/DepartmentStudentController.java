package com.example.campus.controller;

import com.example.campus.dto.Students.StudentDto;
import com.example.campus.model.Student;
import com.example.campus.services.DepartmentService;
import com.example.campus.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentStudentController {
    private final DepartmentService departmentService;
    private final StudentService studentService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY')")
    @PostMapping("/departments/{id}/students")
    @ResponseBody
    public ResponseEntity<StudentDto> createStudent(@PathVariable Long id,@RequestBody Student student){
        return ResponseEntity.ok(studentService.addStudent(id,student));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY','ROLE_STUDENT_AFFAIR')")
    @GetMapping("/departments/{departmentId}/students")
    public ResponseEntity<List<Student>> retireveStudentForDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentService.students(departmentId));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY','ROLE_STUDENT','ROLE_STUDENT_AFFAIR')")
    @GetMapping("/departments/{departmentId}/students/{studentId}")
    public Student retireveStudentsForDepartment(@PathVariable Long departmentId, @PathVariable Long studentId){
        return departmentService.retireveStudents(departmentId,studentId);
    }


}
