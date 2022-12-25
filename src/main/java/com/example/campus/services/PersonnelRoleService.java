package com.example.campus.services;

import com.example.campus.model.Institute;
import com.example.campus.model.Personnel;
import com.example.campus.model.PersonnelRole;
import com.example.campus.repository.PersonnelRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PersonnelRoleService {
    private final PersonnelRoleRepository personnelRoleRepository;

    private final PersonnelRoleRepository userRoleRepository;

    public PersonnelRole saveRole(PersonnelRole role)
    {
        personnelRoleRepository.save(role);
        return  role;
    }

    public Collection<PersonnelRole> getAll()
    {
        return userRoleRepository.findAll();
    }
}
