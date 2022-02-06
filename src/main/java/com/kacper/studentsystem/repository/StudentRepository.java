package com.kacper.studentsystem.repository;

import com.kacper.studentsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameStartsWith(String letter);
    @Query("SELECT MAX(id) FROM Student")
    String getMaxId();
    //Student saveStudentWithId(Student student, int id);
    //void update();
}
