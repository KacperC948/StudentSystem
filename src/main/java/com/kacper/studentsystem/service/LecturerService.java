package com.kacper.studentsystem.service;

import com.kacper.studentsystem.model.Lecturer;

import java.util.List;

public interface LecturerService {
    public Lecturer saveLecturer(Lecturer lecturer);
    public List<Lecturer> getAllLecturers();
}
