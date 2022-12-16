package com.example.campus;

import com.example.campus.model.Faculty;
import com.example.campus.repository.DepartmentRepository;
import com.example.campus.repository.FacultyRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CampusApplication {
	private final FacultyRepository facultyRepository;
	private final DepartmentRepository departmentRepository;

	public CampusApplication(FacultyRepository facultyRepository, DepartmentRepository departmentRepository) {
		this.facultyRepository = facultyRepository;
		this.departmentRepository = departmentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CampusApplication.class, args);

	}

	


}
