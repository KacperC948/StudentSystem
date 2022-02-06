package com.kacper.studentsystem.controller;

import com.kacper.studentsystem.model.StudentCourse;
import com.kacper.studentsystem.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student/course")
@CrossOrigin
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping("/getAll")
    public List<StudentCourse> getAll(){
        return studentCourseService.getAllStudentCourse();
    }
}
