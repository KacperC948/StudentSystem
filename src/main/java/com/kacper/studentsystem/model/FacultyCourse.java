package com.kacper.studentsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "faculties_courses")
public class FacultyCourse {

    @EmbeddedId
    FacultyCourseId id;

    @ManyToOne
    @MapsId("facultyId")
    @JoinColumn(name = "faculty_id")
    Faculty faculty;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    java.sql.Timestamp creationDt;

    public FacultyCourse() {
    }
}
