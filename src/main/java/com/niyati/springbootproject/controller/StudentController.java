package com.niyati.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public String registerNewStudent(@RequestBody Student student) {
        if (student != null) {
            studentService.addNewStudent(student);
            return "Student data is registered successfully";
        } else {
            return "Student data is not registered";
        }
    }
}

