package com.kacper.studentsystem.repository;

import com.kacper.studentsystem.model.StudentCourse;
import com.kacper.studentsystem.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
}
