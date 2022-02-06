package com.kacper.studentsystem.controller;

import com.kacper.studentsystem.model.Faculty;
import com.kacper.studentsystem.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/faculty")
@CrossOrigin
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/add")
    public String add(@RequestBody Faculty faculty){
        if(facultyService.getMaxId() == -1){ //check if date base is empty
            //set id in date base to 1 then save student with id = 1
            //studentService.saveStudentWithId(student,1);
            faculty.setId(1);
            facultyService.saveFaculty(faculty);
            return "New faculty with id = 1 is added!";
        } else {//serwis generujacy losowse dane dodajacy do bazy 1000 wierszy, zapisac czas dodawania kolejnych rekordow
            faculty.setId(getMaxId() + 1);
            facultyService.saveFaculty(faculty);
        }
        return "New faculty is added";
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        //if(getAllStudents() == null)
        facultyService.deleteFaculty(id);
        return "Faculty is deleted!";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        facultyService.deleteAllFaculties();
        return "Done! Table is clear";
    }

    @GetMapping("/getAll")
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("/get/id/max")
    public int getMaxId(){
        return facultyService.getMaxId();
    }
}
