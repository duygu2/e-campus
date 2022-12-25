package com.example.campus.services;

import com.example.campus.dto.Personnel.PersonnelDto;
import com.example.campus.dto.Personnel.PersonnelDtoConverter;
import com.example.campus.model.Personnel;
import com.example.campus.model.PersonnelRole;
import com.example.campus.repository.PersonnelRepository;
import com.example.campus.repository.PersonnelRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonnelService {

    private final PersonnelRepository personnelRepository;
    private final PersonnelDtoConverter personnelDtoConverter;
    private final PersonnelRoleRepository personnelRoleRepository;


    //private final BCryptPasswzordEncoder bCryptPasswordEncoder;


    public PersonnelDto createPersonnel(Long personnelRoleId, PersonnelDto personnelDto) {
        Personnel personnel = new Personnel();
        personnel.setId(personnelDto.getId());
        personnel.setName(personnelDto.getName());
        personnel.setRoles((Collection<PersonnelRole>) personnelDto.getPersonnelRole());

        personnelRepository.save(personnel);

        return personnelDtoConverter.convert(personnel);
    }

    public Collection<Personnel> getAllPersonnel()
    {
        return personnelRepository.findAll();
    }

    public Personnel savePersonnel(Personnel personnel)
    {

       // personnel.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        personnelRepository.save(personnel);
        return personnel;
    }

    public Optional<Personnel> getPersonnel(Long id)
    {
        return personnelRepository.findById(id);
    }

    public PersonnelRole saveRole(PersonnelRole role)
    {

        personnelRoleRepository.save(role);
        return role;
    }

    public void  addRoleToPersonnel(Long id, String roleName)
    {
        Optional<Personnel> personnel = getPersonnel(id);
        PersonnelRole role = personnelRoleRepository.findByName(roleName);
        personnel.get().getRoles().add(role);
    }

    //loadbypersonnel id bak buna personnel roles gelmiyor

}