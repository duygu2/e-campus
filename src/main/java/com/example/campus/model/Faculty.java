package com.example.campus.model;

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
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //@JsonIgnore
    @OneToMany(mappedBy = "faculty")
    private Collection<Student> students;

    @OneToMany(mappedBy = "faculty")
    private List<Department> departmentList = new ArrayList<>();


    //@OneToMany
    //private Collection<Course> courses=new ArrayList<>();



}
