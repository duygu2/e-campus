package com.example.campus.dto.Personnel;

import com.example.campus.model.Personnel;
import com.example.campus.model.PersonnelRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonnelDto {
    private Long id;
    private String name;
    private PersonnelRole personnelRole;
    
}
