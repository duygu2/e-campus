package com.example.campus.services;

import com.example.campus.model.Department;
import com.example.campus.model.Faculty;
import com.example.campus.model.Institute;
import com.example.campus.repository.InstituteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstituteService {
   private final InstituteRepository instituteRepository;

    public Institute addInstitute(Institute institute){
        return instituteRepository.save(institute);
    }

    public Institute getInstitute(Long id){
        return instituteRepository.findById(id).orElse(null);
    }


    public List<Institute> getInstituteAll(){
        return instituteRepository.findAll();
    }

    public void deleteInstitute(Long id){
        instituteRepository.deleteById(id);
    }

    public Collection<Department> departments(Long institueId){
        return instituteRepository.findById(institueId).get().getDepartmentList();
    }

    public Department retireveDepartment(Long instituteId, Long departmentsId) {
        Institute institute = getInstitute(instituteId);
        if(institute == null){
            return null;
        }
        return institute.getDepartmentList().stream()
                .filter(department -> department.getId().equals(departmentsId))
                .findAny()
                .orElse(null);
    }
}
