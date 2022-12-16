package com.example.campus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

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

    @JsonIgnore
    @OneToMany
    private Collection<Student> students;

    @OneToMany
    private Collection<Course> courses=new ArrayList<>();


}
