package com.denishranpariya.jpalearning.repository;

import com.denishranpariya.jpalearning.entity.Guardian;
import com.denishranpariya.jpalearning.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Guardian guardian = Guardian.builder().name("Kiritbhai").email("kirit@gmail.com").mobile("1234567890").build();
        Student student = Student.builder().emailId("thisisdenish@gmail.com").firstName("Denish").lastName("Ranpariya").guardian(guardian).build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("--------------------------------");
        System.out.println(students);
        System.out.println("--------------------------------");
    }

    @Test
    public void printStudentsByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Denish");
        System.out.println("--------------------------------");
        System.out.println(students);
        System.out.println("--------------------------------");
    }

    @Test
    public void printStudentsByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("e");
        System.out.println("--------------------------------");
        System.out.println(students);
        System.out.println("--------------------------------");
    }

    @Test
    public void printStudentsBasedOnGuardianFirstName() {
        List<Student> students = studentRepository.findByGuardianName("Kiritbhai");
        System.out.println("--------------------------------");
        System.out.println(students);
        System.out.println("--------------------------------");
    }

    @Test
    public void printStudentsByFirstNameAndLastName() {
        List<Student> students = studentRepository.findByFirstNameAndLastName("Denish", "Ranpariya");
        System.out.println("--------------------------------");
        System.out.println(students);
        System.out.println("--------------------------------");
    }

    @Test
    public void printStudentsByEmailId() {
        Student student = studentRepository.getStudentsByEmailId("thisisdenish@gmail.com");
        System.out.println("--------------------------------");
        System.out.println(student);
        System.out.println("--------------------------------");
    }

    @Test
    public void printStudentFirstNameByEmailId() {
        String studentFirstName = studentRepository.getStudentFirstNameByEmailId("thisisdenish@gmail.com");
        System.out.println("--------------------------------");
        System.out.println(studentFirstName);
        System.out.println("--------------------------------");
    }

    @Test
    public void printStudentByEmailIdNative() {
        Student student = studentRepository.getStudentsByEmailIdNative("thisisdenish@gmail.com");
        System.out.println("--------------------------------");
        System.out.println(student);
        System.out.println("--------------------------------");
    }

    @Test
    public void printStudentByEmailIdNativeNamedParam() {
        Student student = studentRepository.getStudentsByEmailIdNativeNamedParam("thisisdenish@gmail.com");
        System.out.println("--------------------------------");
        System.out.println(student);
        System.out.println("--------------------------------");
    }

    @Test
    public void updateFirstNameByEmailIdTest() {
        int updateCount = studentRepository.updateFirstNameByEmailId("denish", "thisisdenish@gmail.com");
        System.out.println("--------------------------------");
        System.out.println("Update count : " + updateCount);
        System.out.println("--------------------------------");
    }
}