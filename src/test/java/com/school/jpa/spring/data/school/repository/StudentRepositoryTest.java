package com.school.jpa.spring.data.school.repository;

import com.school.jpa.spring.data.school.entity.Guardian;
import com.school.jpa.spring.data.school.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student = Student.builder()
                .emailId("koto@spring.dev")
                .firstName("Koto")
                .lastName("Be")
                /*.guardianName("Bekoto")
                .guardianEmail("bekoto@spring.dev")
                .guardianMobile("0348756225")*/
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian.builder()
                .name("Koto")
                .email("bekoto@spring.dev")
                .mobile("0348756225")
                .build();

        Student student = Student.builder()
                .firstName("Andriambololontsoa")
                .emailId("andriambololontsoa@spring.dev")
                .lastName("Mecene Phrygien")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent()
    {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = "+studentList);
    }

}