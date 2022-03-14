package com.example.demoproject.student.service;

import com.example.demoproject.student.model.Student;
import com.example.demoproject.student.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService student;

    @BeforeEach
    void setUp() {
        student = new StudentService(studentRepository);
    }

    @Test
    void canGetStudents() {
        student.getStudents();

        verify(studentRepository).findAll();

    }

    @Test
    void canAddNewStudent() {
        Student studentdetails = new Student("Gana", "gana@gmail.com", LocalDate.of(1996, 07, 04));

        student.addNewStudent(studentdetails);
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(studentdetails);
    }


}