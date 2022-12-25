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
public class Institute {
    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @JsonIgnore
    @OneToMany
    private Collection<Student> students;

    @OneToMany
    private Collection<Course> courses=new ArrayList<>();

    @OneToMany(mappedBy = "institute")
    private List<Department> departmentList = new ArrayList<>();

}
