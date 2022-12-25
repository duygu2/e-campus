package com.example.campus.controller;


import com.example.campus.model.Department;
import com.example.campus.model.Institute;
import com.example.campus.services.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/institutes")
@RequiredArgsConstructor
public class InstituteController {
    private final InstituteService instituteService;

    @GetMapping
    public ResponseEntity<List<Institute>> getAllInstitute(){
        return ResponseEntity.ok(instituteService.getInstituteAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institute> getInstituteById(@PathVariable Long id){
        return ResponseEntity.ok(instituteService.getInstitute(id));
    }

    @GetMapping("/{id}/departments")
    public ResponseEntity<Collection<Department>> getInstituteByDepartments(@PathVariable Long id){
        return ResponseEntity.ok(instituteService.departments(id));
    }

    @GetMapping("/{instituteId}/departments/{departmentsId}")
    public ResponseEntity <Department>  getDepartmentForInstitute(@PathVariable Long instituteId,@PathVariable Long departmentsId){
        return ResponseEntity.ok(instituteService.retireveDepartment(instituteId,departmentsId));
    }

    @PostMapping
    public ResponseEntity<Institute> createInstitute(@RequestBody Institute institute){
        return ResponseEntity.ok(instituteService.addInstitute(institute));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitute(@PathVariable Long id){
        instituteService.deleteInstitute(id);
        return ResponseEntity.ok().build();
    }



}
