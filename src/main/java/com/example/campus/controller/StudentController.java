package com.example.campus.controller;

import com.example.campus.dto.Students.StudentDto;
import com.example.campus.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY')")
    @GetMapping()
    public ResponseEntity<?> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_STUDENT','ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY')")
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }


    
}
