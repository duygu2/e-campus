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


    /* @PostMapping("faculties/{facultyId}/departments/{departmentId}/courses")
    @ResponseBody
    public ResponseEntity<Course> createCourse(@PathVariable Long facultyId, @PathVariable Long departmentId, @RequestBody Course course){
       return new ResponseEntity(courseService.createCourse(facultyId,departmentId,course), HttpStatus.CREATED);
    }*/
    //BURADA DFACULTY DEPARTMAN COURSES GİDEREK ULAŞ SİL
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/courses/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long courseId,
                                               @RequestBody Course course)
    {
        return ResponseEntity.ok(courseService.updateCourse(courseId,course));
    }




}
