package com.kacper.studentsystem.controller;

import com.kacper.studentsystem.model.Lecturer;
import com.kacper.studentsystem.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {
    @Autowired
    LecturerService lecturerService;

    @PostMapping("/add")
    public String add(@RequestBody Lecturer lecturer){
        lecturerService.saveLecturer(lecturer);
        return "New lecturer is added";
    }
    @GetMapping("/getAll")
    public List<Lecturer> getAllLecturer() {
        return lecturerService.getAllLecturers();
    }
}
