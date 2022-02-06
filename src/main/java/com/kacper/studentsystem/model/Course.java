package com.kacper.studentsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name ="courses")
public class Course {
    @Id
    int id;
    String name;
    int hours;

    @OneToMany(mappedBy = "course")
    Set<StudentCourse> studentCourses;

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String toString(){
        return this.id + " " + this.name + " " + this.hours;
    }
}
