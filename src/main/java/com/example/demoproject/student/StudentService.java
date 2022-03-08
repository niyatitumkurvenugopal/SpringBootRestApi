package com.example.demoproject.student;

import com.example.demoproject.student.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        boolean existsEmail =studentRepository.selectExistsEmail(student.getEmail());
        if(existsEmail) {
            throw new BadRequestException(
                    "Email " + student.getEmail() + "taken"
            );
        }
            studentRepository.save(student);
        }



    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }


    }

