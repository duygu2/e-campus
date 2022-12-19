package com.example.campus.model;

import com.example.campus.dto.Students.StudentDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    private Faculty faculty;


    @OneToMany(mappedBy = "department")
    private List<Student> students= new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private Collection<Course> courses=new ArrayList<>();


}
