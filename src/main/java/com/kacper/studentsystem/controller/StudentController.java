package com.kacper.studentsystem.controller;

import com.kacper.studentsystem.model.Student;
import com.kacper.studentsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


//punkt dostepu, jak wywoal serwis czyli usluge czyli pewna logika do modelu
//serwisy to implementacje zadan, korzystaja z modelu
//fasada przeyjecie z
@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Transactional
    @PostMapping("/add")
    public String add(@RequestBody Student student){
        int id;
        if(studentService.getMaxId() == -1){ //check if date base is empty
            //set id in date base to 1 then save student with id = 1
            //studentService.saveStudentWithId(student,1);
            student.setId(1);
            studentService.saveStudent(student);
            return "New student with id = 1 is added!";
        } else {
            id = getMaxId() + 1; //serwis generujacy losowse dane dodajacy do bazy 1000 wierszy, zapisac czas dodawania kolejnych rekordow
            student.setId(id);
            studentService.saveStudent(student);
        }
        return "New student is added";
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        //if(getAllStudents() == null)
        studentService.deleteStudent(id);
        return "Student is deleted";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        studentService.deleteAllStudents();
        return "Done! Table is clear";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get/name/{letter}")
    public List<Student> findByNameStartsWith(@PathVariable /*(value = "letter")*/ String letter){
        return studentService.findByNameStartsWith(letter);
    }

    @GetMapping("/get/id/max")
    public int getMaxId(){
        return studentService.getMaxId();
    }



}
