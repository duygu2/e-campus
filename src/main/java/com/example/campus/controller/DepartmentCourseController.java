package com.example.campus.controller;

import com.example.campus.model.Course;
import com.example.campus.model.Department;
import com.example.campus.services.CourseService;
import com.example.campus.services.DepartmentService;
import com.example.campus.services.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class DepartmentCourseController {
    private final CourseService courseService;
    private final DepartmentService departmentService;


    @PostMapping("/departments/{departmentId}/courses")
    @ResponseBody
    public ResponseEntity<Course> createCourse(@PathVariable Long departmentId, @RequestBody Course course){
        return new ResponseEntity(courseService.addCourse(departmentId,course), HttpStatus.CREATED);
    }

    @GetMapping("/departments/{departmentId}/courses")
    public ResponseEntity <Collection<Course>> getCourses(@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.allCourses(departmentId));
    }

    @GetMapping("/departments/{departmentId}/courses/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long departmentId, @PathVariable Long courseId){
        return ResponseEntity.ok(departmentService.courses(departmentId,courseId));
    }


}

