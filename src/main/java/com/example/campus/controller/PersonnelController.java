package com.example.campus.controller;

import com.example.campus.model.Personnel;
import com.example.campus.services.PersonnelService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class PersonnelController {
    private final PersonnelService personnelService;

    @PostMapping
    @RequestMapping("/personnels")
    @ResponseBody
    public ResponseEntity<Personnel> savePersonnel(@RequestBody Personnel personnel) {
        return ResponseEntity.ok(personnelService.savePersonnel(personnel));

    }
    @GetMapping("/personnels")
    public ResponseEntity<?> getAllPersonnels()
    {
        return ResponseEntity.ok(personnelService.getAllPersonnel());
    }


    @PostMapping("/personnels/roles")
    @ResponseBody
    public ResponseEntity<?> addRoleToPersonnel( @RequestBody PersonnelRoleForm form)
    {
        personnelService.addRoleToPersonnel(form.getPersonnelId(), form.getRoleName());
        return ResponseEntity.ok("Successful!");
    }
}

@Data
class PersonnelRoleForm
{
    private Long personnelId;
    private String roleName;
}