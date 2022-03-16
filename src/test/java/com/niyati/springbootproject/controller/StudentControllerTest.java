package com.niyati.springbootproject.controller;

import com.niyati.spring.controller.StudentController;
import com.niyati.spring.model.Student;
import com.niyati.spring.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    StudentService studentService;

//    @Test
//    public void getStudentDetails() {
//        Student student1 = new Student("Gana", "gana@gmail.com", LocalDate.of(1996, 07, 04));
//        Student student2 = new Student("Deepthi", "deepthi@gmail.com", LocalDate.of(1995, 06, 03));
//
//        List<Student> students = Arrays.asList(student1, student2);
//        List<Student> result = studentController.getStudents();
//
//
//        assertThat(result).hasSize(2).contains();
//
//    }

    @Test
    public void addNewStudentDetails() {

        String expected = "Student data is registered successfully";
        Student student = new Student("Gana", "gana@gmail.com", LocalDate.of(1996, 07, 04));

        String result = studentController.registerNewStudent(student);

        assertEquals(expected, result);


    }

}