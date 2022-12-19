package com.example.campus.services;

import com.example.campus.dto.Students.StudentDto;
import com.example.campus.dto.Students.StudentDtoConverter;
import com.example.campus.dto.Students.UpdateStudentRequest;
import com.example.campus.model.Department;
import com.example.campus.model.Student;
import com.example.campus.repository.DepartmentRepository;
import com.example.campus.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentDtoConverter studentDtoConverter;
    private final DepartmentService departmentService;
    private final DepartmentRepository departmentRepository;


    public List<StudentDto> getAllStudents(){

        List<Student> students=studentRepository.findAll();
        List<StudentDto> studentDtoList= new ArrayList<>();
        for(Student student: students){
            studentDtoList.add(studentDtoConverter.convert(student));
        }
        return studentDtoList;
    }

    public StudentDto getStudentById(Long id){

        Optional<Student> accountOptional=studentRepository.findById(id);
        return accountOptional.map(studentDtoConverter::convert).orElse(new StudentDto());
    }

    public StudentDto createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setStudentType(studentDto.getStudentType());
        student.setSchoolNumber(studentDto.getSchoolNumber());

        studentRepository.save(student);

        return studentDtoConverter.convert(student);
    }

    //Only update student name***

    public StudentDto updateStudent(Long id, UpdateStudentRequest updateStudentRequest) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        studentOptional.ifPresent(student -> {
            student.setName(updateStudentRequest.getName());
        });
        return studentOptional.map(studentDtoConverter::convert).orElse(new StudentDto());
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudentCourses(Long id) {
        return (List<Student>) studentRepository.findById(id).orElse(null);
    }

    //öğrenci işleri yapacak ,admin yapacak

    public Student addStudent(Long id, Student student){
        student.setDepartment(departmentRepository.findById(id).orElse(null));

        studentRepository.save(student);
        return student;
    }




  /*  public Collection<StudentDto> getAllStudentByDepartmentID(Long id) {
        Collection<Student> studentList = studentRepository.findAllByDepartmentId(id);
        Collection<StudentDto> studentDtos = new ArrayList<>();
        for(Student student:studentList){
            studentDtos.add(studentDtoConverter.convert(student));
        }
        return (Collection<StudentDto>) new ResponseEntity<Collection<StudentDto>>(studentDtos, HttpStatus.OK);
    }

    public Collection<Student> getAllStudentDepartment(Long id){
        return (Collection<Student>) this.studentRepository.findByDepartmentId(id);

    }*/




//maybe mistake
   }


