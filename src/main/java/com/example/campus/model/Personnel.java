package com.example.campus.model;

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
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)

public class Personnel {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<PersonnelRole> roles = new ArrayList<>();
}
