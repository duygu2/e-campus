package com.example.campus.controller;

import com.example.campus.model.Course;
import com.example.campus.model.Department;
import com.example.campus.model.Student;
import com.example.campus.services.CourseService;
import com.example.campus.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentCourseController {
    private final StudentService studentService;
    private final CourseService courseService;

   /* @PostMapping("/students/{id}/courses")
    @ResponseBody
    public ResponseEntity<Course> addCourse(@PathVariable Long id, @RequestBody Course course){
        return new ResponseEntity(courseService.addStudentCourse(id,course), HttpStatus.CREATED);
    }

    @GetMapping("/students/{id}/courses")
    public ResponseEntity<List<Student>> getStudentsCourse(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getAllStudentCourses(id));
    }*/

}
