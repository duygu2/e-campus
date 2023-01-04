package com.example.campus.services;

import com.example.campus.dto.Students.StudentDto;
import com.example.campus.model.Course;
import com.example.campus.model.Department;
import com.example.campus.model.Student;
import com.example.campus.repository.DepartmentRepository;
import com.example.campus.repository.FacultyRepository;
import com.example.campus.repository.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final InstituteRepository instituteRepository;

    public Department addDepartment(Long id, Department department) {
        department.setFaculty(facultyRepository.findById(id).orElse(null));
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public List<Department> getAllDepartment() {
        return  departmentRepository.findAll();
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Long id, Department department) {
        Optional<Department> departmentOptional = departmentRepository.findById(id);
        departmentOptional.ifPresent(department1 -> {
            department1.setName(department.getName());
            department1.setCourses(department.getCourses());
            departmentRepository.save(department1);
        });
        return departmentOptional.orElse(new Department());
    }


    public List<Student> students(Long departmentId){
        return departmentRepository.findById(departmentId).orElse(null).getStudents();
    }

    public Student retireveStudents(Long departmentId, Long studentId) {
        Department department = getDepartment(departmentId);
        if(department == null){
            return null;
        }

        return department.getStudents().stream()
                .filter(student -> student.getId().equals(studentId))
                .findAny()
                .orElse(null);
    }

    public Collection<Course> allCourses(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null).getCourses();
    }

    public Course courses(Long departmentId, Long courseId) {
        Department department = getDepartment(departmentId);
        if (department== null){
            return null;
        }

        return department.getCourses().stream()
                .filter(course -> course.getId().equals(courseId))
                .findAny()
                .orElse(null);
    }

    public Department addDepartmentByInstitute(Long id, Department department) {
        department.setInstitute(instituteRepository.findById(id).orElse(null));
        return departmentRepository.save(department);
    }



  /*  public ResponseEntity<Student> retireveStudents(Long departmentId, Long studentId) {
        Department department =getDepartment(departmentId);

        return department == null ? null : department.getStudents();
    }*/
}

