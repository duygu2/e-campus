package com.example.campus.services;

import com.example.campus.model.Department;
import com.example.campus.model.Faculty;
import com.example.campus.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public Faculty addFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Long id){
        return facultyRepository.findById(id).get();
    }

   /* public Faculty getFacultyName(String name){
        return facultyRepository.findByFacultyName(name);
    }*/

    public List<Faculty> getFacultyAll(){
        return facultyRepository.findAll();
    }

    public void deleteFaculty(Long id){
         facultyRepository.deleteById(id);
    }

    public Collection<Department> departments(Long facultyId){
        return facultyRepository.findById(facultyId).get().getDepartmentList();
    }

}
