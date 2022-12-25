package com.example.campus.dto.Personnel;


import com.example.campus.model.Personnel;
import com.example.campus.model.PersonnelRole;
import org.springframework.stereotype.Component;

@Component
public class PersonnelDtoConverter {
    public PersonnelDto convert(Personnel personnel){
        return PersonnelDto.builder()
                .id(personnel.getId())
                .name(personnel.getName())
                .personnelRole((PersonnelRole) personnel.getRoles())
                .build();
    }
}
