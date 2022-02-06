package com.kacper.studentsystem.repository;

import com.kacper.studentsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByNameStartsWith(String letter);
    @Query("SELECT MAX(id) FROM Course")
    String getMaxId();
}
