package com.kacper.studentsystem.service;

import com.kacper.studentsystem.model.Course;

import java.util.List;

public interface CourseService {
    public Course saveCourse(Course course);
    public void deleteCourse(int id);
    public void deleteAllCourses();
    public List<Course> getAllCourses();
    public List<Course> findByNameStartsWith(String letter);
    public int getMaxId();
}
