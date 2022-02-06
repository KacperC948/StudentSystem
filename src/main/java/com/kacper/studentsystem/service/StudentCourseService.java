package com.kacper.studentsystem.service;

import com.kacper.studentsystem.model.StudentCourse;
import java.util.List;

public interface StudentCourseService {
    public List<StudentCourse> getAllStudentCourse();
    public void assignCourseToStudent(int id);
}
