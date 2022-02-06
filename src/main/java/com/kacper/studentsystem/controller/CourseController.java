package com.kacper.studentsystem.controller;

import com.kacper.studentsystem.model.Course;
import com.kacper.studentsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Transactional
    @PostMapping("/add")
    public String add(@RequestBody Course course){
        int id;
        if(courseService.getMaxId() == -1){ //check if date base is empty
            //set id in date base to 1 then save student with id = 1
            //studentService.saveStudentWithId(student,1);
            course.setId(1);
            courseService.saveCourse(course);
            return "New course with id = 1 is added!";
        } else {
            id = getMaxId() + 1; //serwis generujacy losowse dane dodajacy do bazy 1000 wierszy, zapisac czas dodawania kolejnych rekordow
            course.setId(id);
            courseService.saveCourse(course);
        }
        return "New course is added";
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        //if(getAllStudents() == null)
        courseService.deleteCourse(id);
        return "Course is deleted";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        courseService.deleteAllCourses();
        return "Done! Table is clear";
    }

    @GetMapping("/getAll")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/get/name/{letter}")
    public List<Course> findByNameStartsWith(@PathVariable /*(value = "letter")*/ String letter){
        return courseService.findByNameStartsWith(letter);
    }

    @GetMapping("/get/id/max")
    public int getMaxId(){
        return courseService.getMaxId();
    }
}
