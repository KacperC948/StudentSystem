package com.kacper.studentsystem.repository;

import com.kacper.studentsystem.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    @Query("SELECT MAX(id) FROM Faculty")
    String getMaxId();
}
