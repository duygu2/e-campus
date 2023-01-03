package com.example.campus.controller;

import com.example.campus.model.Personnel;
import com.example.campus.services.PersonnelService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class PersonnelController {
    private final PersonnelService personnelService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_HR')")
    @PostMapping
    @RequestMapping("/personnels")
    @ResponseBody
    public ResponseEntity<Personnel> savePersonnel(@RequestBody Personnel personnel) {
        return ResponseEntity.ok(personnelService.savePersonnel(personnel));

    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_HR')")
    @GetMapping("/personnels")
    public ResponseEntity<?> getAllPersonnels()
    {
        return ResponseEntity.ok(personnelService.getAllPersonnel());
    }


    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_HR')")
    @PostMapping("/personnels/{id}/roles")
    @ResponseBody
    public ResponseEntity<?> addRoleToPersonnel(@PathVariable Long id, @RequestBody PersonnelRoleForm form)
    {
        personnelService.addRoleToPersonnel(id, form.getRoleName());
        return ResponseEntity.ok("Successful!");
    }
}

@Data
class PersonnelRoleForm
{
    private Long personnelId;
    private String roleName;
}