package com.example.campus.controller;


import com.example.campus.model.Department;
import com.example.campus.model.Institute;
import com.example.campus.services.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/institutes")
@RequiredArgsConstructor
public class InstituteController {
    private final InstituteService instituteService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_INSTITUTE','ROLE_STUDENT','ROLE_STUDENT_AFFAIR')")
    @GetMapping
    public ResponseEntity<List<Institute>> getAllInstitute(){
        return ResponseEntity.ok(instituteService.getInstituteAll());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_INSTITUTE','ROLE_STUDENT','ROLE_STUDENT_AFFAIR')")
    @GetMapping("/{id}")
    public ResponseEntity<Institute> getInstituteById(@PathVariable Long id){
        return ResponseEntity.ok(instituteService.getInstitute(id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_INSTITUTE','ROLE_STUDENT','ROLE_DEPARTMENT','ROLE_STUDENT_AFFAIR')")
    @GetMapping("/{id}/departments")
    public ResponseEntity<Collection<Department>> getInstituteByDepartments(@PathVariable Long id){
        return ResponseEntity.ok(instituteService.departments(id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_INSTITUTE','ROLE_STUDENT','ROLE_DEPARTMENT','ROLE_STUDENT_AFFAIR')")
    @GetMapping("/{instituteId}/departments/{departmentsId}")
    public ResponseEntity <Department>  getDepartmentForInstitute(@PathVariable Long instituteId,@PathVariable Long departmentsId){
        return ResponseEntity.ok(instituteService.retireveDepartment(instituteId,departmentsId));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Institute> createInstitute(@RequestBody Institute institute){
        return ResponseEntity.ok(instituteService.addInstitute(institute));
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitute(@PathVariable Long id){
        instituteService.deleteInstitute(id);
        return ResponseEntity.ok().build();
    }



}
