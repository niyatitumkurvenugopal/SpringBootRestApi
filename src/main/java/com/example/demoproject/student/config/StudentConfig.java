package com.example.demoproject.student.config;

import com.example.demoproject.student.model.Student;
import com.example.demoproject.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student niyati = new Student(
                    "Niyati",
                    "niyati@gmail.com",
                    LocalDate.of(1999, 12, 7)

            );

            Student gana = new Student(
                    "Bindu",
                    "bindu@gmail.com",
                    LocalDate.of(1996, 07, 04)

            );
            repository.saveAll(
                    List.of(niyati, gana)
            );
        };
    }
}