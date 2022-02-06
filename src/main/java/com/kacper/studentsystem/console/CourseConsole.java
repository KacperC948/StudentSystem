package com.kacper.studentsystem.console;

import com.kacper.studentsystem.model.Course;
import com.kacper.studentsystem.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
@Slf4j
public class CourseConsole implements CommandLineRunner {
    @Autowired
    CourseService courseService;



    @Override
    public void run(String... args) throws Exception {
        courseService.deleteAllCourses();
        for(int i = 1; i < 11; i++){
            Course course = new Course();
            course.setId(i);
            course.setName("Course" + i);
            course.setHours(i+10);
            courseService.saveCourse(course);
        }
        List<Course> courses = courseService.getAllCourses();
        courses.forEach(course -> {System.out.println(course.toString());});
    }
}