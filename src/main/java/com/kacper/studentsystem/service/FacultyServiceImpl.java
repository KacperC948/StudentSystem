package com.kacper.studentsystem.service;

import com.kacper.studentsystem.model.Faculty;
import com.kacper.studentsystem.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(int id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public void deleteAllFaculties() {
        facultyRepository.deleteAll();
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public int getMaxId() {
        String max = "";
        try {
            max = facultyRepository.getMaxId();
            if (max.equalsIgnoreCase("NULL")) {
                return -1;
            } else {
                return Integer.parseInt(max);
            }
        } catch (Exception e) {
            return -1;
        }
    }
}
