package com.example.campus.controller;

import com.example.campus.model.Student;
import com.example.campus.services.DepartmentService;
import com.example.campus.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentStudentController {
    private final DepartmentService departmentService;
    private final StudentService studentService;

    @PostMapping("/departments/{id}/students")
    @ResponseBody
    public ResponseEntity<Student> createStudent(@PathVariable Long id,@RequestBody Student student){
        return ResponseEntity.ok(studentService.addStudent(id,student));
    }

    @GetMapping("/departments/{departmentId}/students")
    public ResponseEntity<List<Student>> retireveStudentForDepartment(@PathVariable Long departmentId) {
        return ResponseEntity.ok(departmentService.students(departmentId));
    }


    @GetMapping("/departments/{departmentId}/students/{studentId}")
    public Student retireveStudentsForDepartment(@PathVariable Long departmentId, @PathVariable Long studentId){
        return departmentService.retireveStudents(departmentId,studentId);
    }


}
