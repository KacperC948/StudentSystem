package com.kacper.studentsystem.console;

import com.kacper.studentsystem.model.Student;
import com.kacper.studentsystem.repository.StudentRepository;
import com.kacper.studentsystem.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
@Slf4j
public class StudentConsole implements CommandLineRunner {
    @Autowired
    StudentService studentService;



    @Override
    public void run(String... args) throws Exception {
        studentService.deleteAllStudents();
        for(int i = 1; i < 11; i++){
            Student student = new Student();
            student.setId(i);
            student.setName("Student" + i);
            student.setAddress("Polska" + i);
            student.setAge(i);
            student.setYear_of_study(i);
            studentService.saveStudent(student);
        }
        List<Student> students = studentService.getAllStudents();
        students.forEach(student -> {System.out.println(student.toString());});
    }
}