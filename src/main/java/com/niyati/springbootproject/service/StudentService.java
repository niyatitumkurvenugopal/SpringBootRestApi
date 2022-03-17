package com.niyati.springbootproject.service;

import com.niyati.springbootproject.exception.EmailTakenException;
import com.niyati.springbootproject.model.Student;
import com.niyati.springbootproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public boolean addNewStudent(Student student) {
        Optional<Student> existsEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (existsEmail.isPresent()) {
            throw new EmailTakenException("Email " + student.getEmail() + " taken");
        } else {
            studentRepository.save(student);
            return true;
        }
    }
}











