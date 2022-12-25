package com.example.campus.services;

import com.example.campus.model.Course;
import com.example.campus.repository.CourseRepository;
import com.example.campus.repository.DepartmentRepository;
import com.example.campus.repository.FacultyRepository;
import com.example.campus.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    public Course getCourseById(Long id){
        return courseRepository.findById(id).get();
    }

    public List<Course> getCourseAll(){
        return courseRepository.findAll();
    }

    public Course addCourse(Long id, Course course){
        course.setDepartment(departmentRepository.findById(id).orElse(null));
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Long courseId, Course course) {
        return courseRepository.findById(courseId)
                .map(courses -> {
                    courses.setName(course.getName());
                    courses.setPersonnel(course.getPersonnel());
                    return courseRepository.save(courses);
                })
                .orElseGet(()->{
                    return courseRepository.save(course);
                });
    }




   /* public Course addStudentCourse(Long id, Course course) {
        course.setStudents(studentRepository.findById(id).stream().toList());
        return courseRepository.save(course);
    }*/

}
