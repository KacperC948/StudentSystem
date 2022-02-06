package com.kacper.studentsystem.service;

import com.kacper.studentsystem.model.Faculty;

import java.util.List;

public interface FacultyService {
    public Faculty saveFaculty(Faculty faculty);
    public void deleteFaculty(int id);
    public void deleteAllFaculties();
    public List<Faculty> getAllFaculties();
    public int getMaxId();
}
