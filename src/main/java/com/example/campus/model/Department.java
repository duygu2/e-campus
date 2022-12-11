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

    @ManyToOne
    private Faculty faculty;

    @JsonIgnore
    @OneToMany
    private Collection<User> users;

    @OneToMany
    private Collection<Course> courses=new ArrayList<>();


}
