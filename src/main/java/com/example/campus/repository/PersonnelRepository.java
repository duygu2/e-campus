package com.example.campus.repository;

import com.example.campus.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel,Long> {
}
