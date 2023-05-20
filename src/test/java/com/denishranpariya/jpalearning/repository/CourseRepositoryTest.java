package com.denishranpariya.jpalearning.repository;

import com.denishranpariya.jpalearning.entity.Course;
import com.denishranpariya.jpalearning.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("-----------------------------------");
        System.out.println("Courses : " + courses);
        System.out.println("-----------------------------------");
    }

    @Test
    public void saveCourse() {
        Teacher teacher = Teacher.builder().firstName("Telusko").lastName("aliens").build();
        Course course = Course.builder().teacher(teacher).title("SpringBoot").credit(6).build();
        courseRepository.save(course);
    }
}