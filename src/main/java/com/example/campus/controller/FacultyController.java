package com.example.campus.controller;

import com.example.campus.model.Department;
import com.example.campus.model.Faculty;
import com.example.campus.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY','ROLE_STUDENT_AFFAIR')")
    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        return ResponseEntity.ok(facultyService.getFacultyAll());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_FACULTY')")
    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id){
        return ResponseEntity.ok(facultyService.getFaculty(id));
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY','ROLE_STUDENT_AFFAIR')")
    @GetMapping("/{id}/departments")
    public ResponseEntity<Collection<Department>> getFacultyByDepartments(@PathVariable Long id){
        return ResponseEntity.ok(facultyService.departments(id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY','ROLE_STUDENT_AFFAIR')")
    @GetMapping("/{facultiesId}/departments/{departmentsId}")
    public ResponseEntity <Department>  getDepartmentForFaculty(@PathVariable Long facultiesId,@PathVariable Long departmentsId){
        return ResponseEntity.ok(facultyService.retireveDepartment(facultiesId,departmentsId));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_FACULTY')")
    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty){
        return ResponseEntity.ok(facultyService.addFaculty(faculty));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_FACULTY')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

}
