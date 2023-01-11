package com.example.campus.services;

import com.example.campus.model.Faculty;
import com.example.campus.model.PersonnelRole;
import com.example.campus.repository.FacultyRepository;
import com.example.campus.repository.PersonnelRoleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PersonnelRoleServiceTest {
    @Mock

    private PersonnelRoleRepository personnelRoleRepository;
    private PersonnelRoleRepository userRoleRepository;

    private AutoCloseable autoCloseable;
    private PersonnelRoleService personnelRoleService;


    @BeforeEach
    void setUp(){
        autoCloseable= MockitoAnnotations.openMocks(this);
        personnelRoleService = new PersonnelRoleService(personnelRoleRepository,userRoleRepository);
    }
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void saveRole() {
        Long id = 1L;
        PersonnelRole personnelRole= new PersonnelRole(id,"Personnel Role");
        when(personnelRoleRepository.save(personnelRole)).thenReturn(personnelRole);

        // Act (execute the test)
        PersonnelRole savedRole = personnelRoleService.saveRole(personnelRole);

        // Assert (verify the results)
        assertEquals(personnelRole, savedRole);
    }

//    @Test
//    void getAll() {
//        Long id=1L;
//        List<PersonnelRole> personnelRoleList = Arrays.asList(new PersonnelRole(id,"Personnel Role"));
//
//        when(personnelRoleRepository.findAll()).thenReturn(personnelRoleList);
//
//        // Act (execute the test)
//        List<PersonnelRole> actualPersonelRoleList = personnelRoleService.getAll();
//
//
//        // Assert (verify the results)
//        assertEquals(personnelRoleList, actualPersonelRoleList);
//    }
}