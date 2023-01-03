package com.example.campus.controller;


import com.example.campus.model.Department;

import com.example.campus.services.DepartmentService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<?> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartment(id));
    }

    @PostMapping("/faculties/{id}/departments")
    @ResponseBody
    public ResponseEntity<Department> addDepartment(@PathVariable Long id,@RequestBody Department department){
        return new ResponseEntity(departmentService.addDepartment(id,department), HttpStatus.CREATED);
    }

    @PostMapping("/institutes/{id}/departments")
    @ResponseBody
    public ResponseEntity<Department> addDepartmentByInstitute(@PathVariable Long id,@RequestBody Department department){
        return new ResponseEntity(departmentService.addDepartmentByInstitute(id,department), HttpStatus.CREATED);
    }

    @DeleteMapping("/departments/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }
    //@GetMapping("faculties/{facultiesId}/departments/{departmentId}")

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department){
        return ResponseEntity.ok(departmentService.updateDepartment(id,department));
    }



}
