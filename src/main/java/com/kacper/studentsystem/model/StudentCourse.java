package com.kacper.studentsystem.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "students_courses")
@Entity
public class StudentCourse {

    @EmbeddedId
    StudentCourseId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    java.sql.Timestamp creationDt;

    public StudentCourse(StudentCourseId id, Student student, Course course, Timestamp creationDt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.creationDt = creationDt;
    }

    public StudentCourse() {
    }

    public StudentCourseId getId() {
        return id;
    }

    public void setId(StudentCourseId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Timestamp getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Timestamp creationDt) {
        this.creationDt = creationDt;
    }
}
