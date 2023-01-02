package com.example.campus.controller;

import com.example.campus.model.Department;
import com.example.campus.model.Faculty;
import com.example.campus.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculty(){
        return ResponseEntity.ok(facultyService.getFacultyAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id){
        return ResponseEntity.ok(facultyService.getFaculty(id));
    }

    @GetMapping("/{id}/departments")
    public ResponseEntity<Collection<Department>> getFacultyByDepartments(@PathVariable Long id){
        return ResponseEntity.ok(facultyService.departments(id));
    }

    @GetMapping("/{facultiesId}/departments/{departmentsId}")
    public ResponseEntity <Department>  getDepartmentForFaculty(@PathVariable Long facultiesId,@PathVariable Long departmentsId){
        return ResponseEntity.ok(facultyService.retireveDepartment(facultiesId,departmentsId));
    }
    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty){
        return ResponseEntity.ok(facultyService.addFaculty(faculty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Long id){
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

}
