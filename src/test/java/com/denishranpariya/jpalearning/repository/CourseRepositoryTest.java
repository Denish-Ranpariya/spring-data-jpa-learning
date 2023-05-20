package com.denishranpariya.jpalearning.repository;

import com.denishranpariya.jpalearning.entity.Course;
import com.denishranpariya.jpalearning.entity.Student;
import com.denishranpariya.jpalearning.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination() {
        Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        Page<Course> page = courseRepository.findAll(firstPagewithThreeRecords);

        List<Course> courses = page.getContent();
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditsDescending = PageRequest.of(0, 2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditsDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder().firstName("Lizze").lastName("Morgan").build();

        Student student = Student.builder().firstName("Abhishek").lastName("Singh").emailId("abhishek@gmail.com").build();

        Course course = Course.builder().title("AI").credit(12).teacher(teacher).students(List.of(student)).build();
        
        courseRepository.save(course);
    }
}