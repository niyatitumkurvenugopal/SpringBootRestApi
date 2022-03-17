package com.niyati.springbootproject.controller;

import com.niyati.springbootproject.model.Student;
import com.niyati.springbootproject.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    StudentService studentService;

    @Test
    public void getStudentDetails() {
        Student student1 = new Student(1L, "Gana", "gana@gmail.com", LocalDate.of(1996, 07, 04), 25);
        Student student2 = new Student(2L, "Deepthi", "deepthi@gmail.com", LocalDate.of(1995, 06, 03), 26);
        List<Student> studentDetailsExpected = new ArrayList<Student>();
        List<Student> studentDetailsResult = studentController.getStudents();


        assertEquals(studentDetailsExpected, studentDetailsResult);

    }

    @Test
    public void addNewStudentDetails() {

        String newStudentDetailExpected = "Student data is registered successfully";
        Student student = new Student(1L, "Gana", "gana@gmail.com", LocalDate.of(1996, 07, 04), 26);

        String newStudentDetailResult = studentController.registerNewStudent(student);

        assertEquals(newStudentDetailExpected, newStudentDetailResult);


    }

}