package com.kacper.studentsystem.service;

import com.kacper.studentsystem.model.Course;
import com.kacper.studentsystem.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> findByNameStartsWith(String letter) {
        return courseRepository.findByNameStartsWith(letter);
    }

    @Override
    public int getMaxId() {
        String max = "";
        try{
            max = courseRepository.getMaxId();
            if(max.equalsIgnoreCase("NULL")){
                return -1;
            } else {
                return Integer.parseInt(max);
            }
        } catch(Exception e) {
            //logger.info("GetMaxId" + max);
            //logger.error("" + e.getStackTrace());
            return -1;
        }
    }
}
