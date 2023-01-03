package com.example.campus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToOne
    private Faculty faculty;

    @JsonIgnore
    @ManyToOne
    private Institute institute;


    @OneToMany(mappedBy = "department")
    private List<Student> students= new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private Collection<Course> courses=new ArrayList<>();


}
