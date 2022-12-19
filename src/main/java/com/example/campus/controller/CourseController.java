package com.example.campus.controller;

import com.example.campus.model.Course;
import com.example.campus.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<?> getCourseAll(){
        return ResponseEntity.ok(courseService.getCourseAll());
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping("/departments/{id}/courses")
    @ResponseBody
    public ResponseEntity<Course> addCourse(@PathVariable Long id, @RequestBody Course course){

        return new ResponseEntity(courseService.addCourse(id,course),HttpStatus.CREATED);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

   // @PostMapping("/students/{id}/courses")



}
