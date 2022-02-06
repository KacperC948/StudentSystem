package com.kacper.studentsystem.service;

import com.kacper.studentsystem.model.Student;

import java.util.List;

//klasa abstrakcyjna w ktorej sa tylko metody bez private, proteckted lub public
public interface StudentService {
    public Student saveStudent(Student student);
    public void deleteStudent(int id);
    public void deleteAllStudents();
    public List<Student> getAllStudents();
    public List<Student> findByNameStartsWith(String letter);
    public int getMaxId();
    //public Student saveStudentWithId(Student student, int id);
}
