package com.kacper.studentsystem.model;

import javax.persistence.*;
import java.util.Set;

//annotation
@Entity
@Table(name = "students")
public class Student {
    @Id //primary key UUID
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private int year_of_study;
    private String name;
    private String address;

    @OneToMany(mappedBy = "student") //nazwa zmieneje ktora jest zdefiniowana w StudentCourse
    Set<StudentCourse> studentCourse;

    public Student() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public int getYear_of_study() { return year_of_study; }

    public void setYear_of_study(int year_of_study) { this.year_of_study = year_of_study; }

    public String toString(){
        return this.id + " " + this.name + " " + this.address + " " + this.age + " " + this.year_of_study;
    }
}
