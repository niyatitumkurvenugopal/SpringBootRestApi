package com.example.demoproject.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository test;

    @AfterEach
    void tearDown(){
        test.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentEmailExists() {
        String email="gana@gmail.com";
        Student student= new Student(
                "Gana",
                email,
                LocalDate.of(1996,07,04)
        );
        test.save(student);

        Boolean exists = test.selectExistsEmail(email);

        assertThat(exists).isTrue();

    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExists() {
        String email="gana@gmail.com";

        Boolean exists = test.selectExistsEmail(email);

        assertThat(exists).isFalse();

    }
}