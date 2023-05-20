package com.denishranpariya.jpalearning.repository;

import com.denishranpariya.jpalearning.entity.Course;
import com.denishranpariya.jpalearning.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseJava = Course.builder().title("Java").credit(5).build();
        Course courseJS = Course.builder().title("JavaScript").credit(5).build();
        Teacher teacher = Teacher.builder()
                .firstName("Navin")
                .lastName("Reddy")
//                .courses(List.of(courseJava, courseJS))
                .build();
        teacherRepository.save(teacher);
    }

}