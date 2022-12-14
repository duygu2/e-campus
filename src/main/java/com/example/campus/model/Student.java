package com.example.campus.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mail;
    private String password;
    private Long schoolNumber;
    private StudentType studentType;
    private String Role = "ROLE_STUDENT";


    @JsonIgnore
    @ManyToOne
    private Department department;

    @JsonIgnore
    @ManyToOne
    private Faculty faculty;

}
