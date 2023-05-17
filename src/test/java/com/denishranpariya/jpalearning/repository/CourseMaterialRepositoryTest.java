package com.denishranpariya.jpalearning.repository;

import com.denishranpariya.jpalearning.entity.Course;
import com.denishranpariya.jpalearning.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseMaterialTest() {
        Course course = Course.builder().title("DSA").credit(6).build();

        courseRepository.save(course);

        CourseMaterial courseMaterial = CourseMaterial.builder().url("https://www.google.com").course(course).build();

        courseMaterialRepository.save(courseMaterial);
    }
}