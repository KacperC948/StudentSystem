package com.kacper.studentsystem.service;

import com.kacper.studentsystem.model.Course;
import com.kacper.studentsystem.model.Student;
import com.kacper.studentsystem.model.StudentCourse;
import com.kacper.studentsystem.model.StudentCourseId;
import com.kacper.studentsystem.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    StudentCourseRepository studentCourseRepository;

    @Autowired
    CourseService courseService;

    @Override
    public List<StudentCourse> getAllStudentCourse() {
        return studentCourseRepository.findAll();
    }

    @Override
    public void assignCourseToStudent(int id) {
        Student student = new Student();
        student.setId(id);
        List<Course> courses = courseService.getAllCourses();
        courses.forEach(course -> {
            StudentCourseId studentCourseId = new StudentCourseId(student.getId(),course.getId());
            StudentCourse studentCourse = new StudentCourse(studentCourseId, student, course, new Timestamp(System.currentTimeMillis()));
            studentCourseRepository.save(studentCourse);
        });
    }
}
