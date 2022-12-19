package com.example.campus.services;

import com.example.campus.model.Course;
import com.example.campus.model.Department;
import com.example.campus.model.Student;
import com.example.campus.repository.CourseRepository;
import com.example.campus.repository.DepartmentRepository;
import com.example.campus.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final StudentRepository studentRepository;

    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }

    public List<Course> getCourseAll(){
        return courseRepository.findAll();
    }

    public Course addCourse(Long id, Course course){
        course.setDepartment(departmentRepository.findById(id).get());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }


   /* public Course addStudentCourse(Long id, Course course) {
        course.setStudents(studentRepository.findById(id).stream().toList());
        return courseRepository.save(course);
    }*/

}
