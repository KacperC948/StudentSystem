package com.kacper.studentsystem.service;

import com.kacper.studentsystem.controller.LoggingController;
import com.kacper.studentsystem.model.Student;
import com.kacper.studentsystem.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findByNameStartsWith(String letter){
        //zwracanie listy studentow zawierajacych dana pierwsza litere w imieniu
        return studentRepository.findByNameStartsWith(letter);
    }

    @Override
    public int getMaxId() {
        String max = "";
        try{
            max = studentRepository.getMaxId();
            if(max.equalsIgnoreCase("NULL")){
                return -1;
            } else {
                return Integer.parseInt(max);
            }
        } catch(Exception e) {
            logger.info("GetMaxId" + max);
            logger.error("" + e.getStackTrace());
            return -1;
        }
    }
}
