package com.example.campus.services;

import com.example.campus.model.Department;
import com.example.campus.model.Faculty;
import com.example.campus.model.Institute;
import com.example.campus.repository.FacultyRepository;
import com.example.campus.repository.InstituteRepository;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class InstituteServiceTest {
    @Mock
    private InstituteRepository instituteRepository;
    private AutoCloseable autoCloseable;
    private DepartmentService departmentService;
    private InstituteService instituteService;

    @BeforeEach
    void setUp(){
        autoCloseable= MockitoAnnotations.openMocks(this);
        instituteService = new InstituteService(instituteRepository);
    }
    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void addInstitute() {
        Institute institute = new Institute(null,"Enstitü",new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        when(instituteRepository.save(institute)).thenReturn(institute);

        // Act (execute the test)
        Institute savedInstitute = instituteService.addInstitute(institute);

        // Assert (verify the results)
        assertEquals(institute, savedInstitute);
    }

    @Test
    void getInstitute() {
        Long id=1L;
        Institute institute = new Institute(id,"Enstitü",new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        assertNotNull(institute.getId());

        when(instituteRepository.findById(id)).thenReturn(Optional.of(institute));

        // Act (execute the test)
        Institute actualInstitute = instituteService.getInstitute(id);

        // Assert (verify the results)
        assertEquals(institute, actualInstitute);
    }

    @Test
    void getInstituteAll() {
        List<Institute> instituteList = Arrays.asList(new Institute(1L,"Enstitü",new ArrayList<>(), new ArrayList<>(),new ArrayList<>()));

        when(instituteRepository.findAll()).thenReturn(instituteList);

        // Act (execute the test)
        List<Institute> actualInstituteList = instituteService.getInstituteAll();

        // Assert (verify the results)
        assertEquals(instituteList, actualInstituteList);
    }

    @Test
    void deleteInstitute() {
        Long id = 1L;
        Institute institute = new Institute(id,"Enstitü",new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        doNothing().when(instituteRepository).deleteById(id);

        // Act (execute the test)
        instituteService.deleteInstitute(id);

        // Assert (verify the results)
        verify(instituteRepository, times(1)).deleteById(id);
    }

    @Test
    void departments() {
    }

    @Test
    void retireveDepartment() {
    }
}