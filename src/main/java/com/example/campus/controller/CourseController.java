package com.example.campus.controller;

import com.example.campus.model.Course;
import com.example.campus.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_STUDENT_AFFAIR','ROLE_STUDENT','ROLE_FACULTY')")
    @GetMapping("/courses")
    public ResponseEntity<?> getCourseAll(){
        return ResponseEntity.ok(courseService.getCourseAll());
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY')")
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_DEPARTMENT','ROLE_FACULTY')")
    @PutMapping("/courses/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId,
                                               @RequestBody Course course)
    {
        return ResponseEntity.ok(courseService.updateCourse(courseId,course));
    }




}
