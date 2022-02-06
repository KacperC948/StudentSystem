package com.kacper.studentsystem.console;

import com.kacper.studentsystem.model.Course;
import com.kacper.studentsystem.service.CourseService;
import com.kacper.studentsystem.service.StudentCourseService;
import com.kacper.studentsystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
@Slf4j
public class StudentCourseConsole implements CommandLineRunner {
    @Autowired
    StudentCourseService studentCourseService;

    @Autowired
    StudentService studentService;


    @Override
    public void run(String... args) throws Exception {
        int id = studentService.getMaxId();
        studentCourseService.assignCourseToStudent(id);
    }
}