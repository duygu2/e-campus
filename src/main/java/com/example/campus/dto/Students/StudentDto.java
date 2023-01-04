package com.example.campus.dto.Students;

import com.example.campus.model.Department;
import com.example.campus.model.StudentType;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StudentDto {
    private Long id;
    private String name;
    private Long schoolNumber;
    private StudentType studentType;
   
}