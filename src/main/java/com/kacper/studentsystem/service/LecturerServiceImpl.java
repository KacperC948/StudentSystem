package com.kacper.studentsystem.service;

import com.kacper.studentsystem.model.Lecturer;
import com.kacper.studentsystem.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerServiceImpl implements LecturerService{

    @Autowired
    LecturerRepository lecturerRepository;

    @Override
    public Lecturer saveLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }
}
