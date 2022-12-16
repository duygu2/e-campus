package com.example.campus.dto.Students;

import com.example.campus.dto.Students.StudentDto;
import com.example.campus.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDtoConverter {
    public StudentDto convert(Student student){
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .schoolNumber(student.getSchoolNumber())
                .studentType(student.getStudentType())
                .build();
    }
}
