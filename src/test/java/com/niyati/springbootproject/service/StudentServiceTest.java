package com.niyati.springbootproject.service;


import com.niyati.springbootproject.model.Student;
import com.niyati.springbootproject.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService = new StudentService(studentRepository);
    }

    @Test
    void canGetStudents() {

        Student student1 = new Student(1L, "Gana", "gana@gmail.com", LocalDate.of(1996, 07, 04), 25);
        Student student2 = new Student(2L, "Deepthi", "deepthi@gmail.com", LocalDate.of(1995, 06, 03), 26);
        List<Student> studentDetailsExpected = new ArrayList<Student>();
        List<Student> studentDetailsresult = studentService.getStudents();


        assertEquals(studentDetailsExpected, studentDetailsresult);

    }

    @Test
    void canAddNewStudent() {
        Student studentdetails = new Student(1L, "Gana", "gana@gmail.com", LocalDate.of(1996, 07, 04), 25);
        boolean newStudentDetailExpected = true;
        boolean newStudentDetailResult = studentService.addNewStudent(studentdetails);

        assertEquals(newStudentDetailExpected, newStudentDetailResult);
    }


}