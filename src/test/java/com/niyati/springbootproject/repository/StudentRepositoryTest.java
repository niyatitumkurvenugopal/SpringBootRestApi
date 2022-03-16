package com.niyati.springbootproject.repository;

import com.niyati.springbootproject.model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository student;

    @AfterEach
    void tearDown() {
        student.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentEmailExists() {
        String email = "gana@gmail.com";
        Student studentdetails = new Student("Gana", email, LocalDate.of(1996, 07, 04));
        student.save(studentdetails);

        Boolean exists = student.selectExistsEmail(email);

        assertThat(exists).isTrue();

    }

    @Test
    void itShouldCheckIfStudentEmailDoesNotExists() {
        String email = "gana@gmail.com";

        Boolean exists = student.selectExistsEmail(email);

        assertThat(exists).isFalse();

    }
}


