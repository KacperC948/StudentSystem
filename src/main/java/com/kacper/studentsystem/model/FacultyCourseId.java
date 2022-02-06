package com.kacper.studentsystem.model;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class FacultyCourseId implements Serializable {
    @Column(name = "faculty_id")
    int facultyId;

    @Column(name = "course_id")
    int courseId;

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public FacultyCourseId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        FacultyCourseId that = (FacultyCourseId) o;
        return Objects.equals(facultyId, that.facultyId) &&
                Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, courseId);
    }
}
