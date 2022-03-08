package com.example.demoproject.student;

import com.example.demoproject.student.exception.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService test;

    @BeforeEach
    void setUp(){
        test=new StudentService(studentRepository);
    }

    @Test
    void canGetStudents() {
        test.getStudents();

        verify(studentRepository).findAll();

    }

    @Test
    void canAddNewStudent() {
        Student student= new Student(
                "Gana",
                "gana@gmail.com",
                LocalDate.of(1996,07,04)
        );
        test.addNewStudent(student);
        ArgumentCaptor<Student>studentArgumentCaptor= ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowWhenEmailIsTaken() {

        Student student= new Student(
                "Gana",
                "gana@gmail.com",
                LocalDate.of(1996,07,04)
        );
        given(studentRepository.selectExistsEmail(student.getEmail()))
                .willReturn(true);
        assertThatThrownBy(()->test.addNewStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + "taken");

        verify(studentRepository,never()).save(any());
    }

    @Autowired
    private StudentService studentService;

    @MockBean
    public StudentRepository studentRepo;






}