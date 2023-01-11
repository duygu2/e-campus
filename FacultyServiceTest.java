package com.example.campus.services;

import com.example.campus.model.Department;
import com.example.campus.model.Faculty;
import com.example.campus.model.Institute;
import com.example.campus.repository.FacultyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FacultyServiceTest {
    @Mock
    @Autowired
    private FacultyRepository facultyRepository;
    private AutoCloseable autoCloseable;
    private DepartmentService departmentService;


    private FacultyService  facultyService;

    @BeforeEach
    void setUp(){
        autoCloseable= MockitoAnnotations.openMocks(this);
        facultyService = new FacultyService(facultyRepository);
    }
    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }



    @Test

    void addFacultyTest() {

        Faculty faculty = new Faculty(1L, "fakülte", new ArrayList<>(), new ArrayList<>());
        when(facultyRepository.save(faculty)).thenReturn(faculty);

        // Act (execute the test)
        Faculty savedFaculty = facultyService.addFaculty(faculty);

        // Assert (verify the results)
        assertEquals(faculty, savedFaculty);
    }


    @Test
    void getFacultyTest() {

        Faculty faculty = new Faculty(null, "fakülte", null, new ArrayList<>());
        assertNotNull(faculty.getId());

        when(facultyRepository.findById(id)).thenReturn(Optional.of(faculty));

        // Act (execute the test)
        Faculty actualFaculty = facultyService.getFaculty(id);

        // Assert (verify the results)
        assertEquals(faculty, actualFaculty);
    }

    @Test
    void getFacultyAllTest() {
        List<Faculty> facultyList = Arrays.asList(new Faculty(1L, "fakülte", null, new ArrayList<>()));

        when(facultyRepository.findAll()).thenReturn(facultyList);

        // Act (execute the test)
        List<Faculty> actualFacultyList = facultyService.getFacultyAll();

        // Assert (verify the results)
        assertEquals(facultyList, actualFacultyList);
    }

    @Test
    void deleteFaculty() {
        Long id = 1L;
        Faculty faculty = new Faculty(id, "fakülte", null, new ArrayList<>());
        doNothing().when(facultyRepository).deleteById(id);

        // Act (execute the test)
        facultyService.deleteFaculty(id);

        // Assert (verify the results)
        verify(facultyRepository, times(1)).deleteById(id);
    }




}
