package com.example.campus.services;

import com.example.campus.dto.Students.StudentDto;
import com.example.campus.dto.Students.StudentDtoConverter;
import com.example.campus.dto.Students.UpdateStudentRequest;
import com.example.campus.model.Student;
import com.example.campus.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentDtoConverter studentDtoConverter;

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



   /* public Student updateStudent(Long id,Student student){
        Optional<Student> studentOptional=studentRepository.findById(id);

    }*/


//maybe mistake
   }


