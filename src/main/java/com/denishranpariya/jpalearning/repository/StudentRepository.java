package com.denishranpariya.jpalearning.repository;

import com.denishranpariya.jpalearning.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentsByEmailId(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);

    //Native Query
    @Query(value = "SELECT * FROM tbl_student WHERE email_address = ?1", nativeQuery = true)
    Student getStudentsByEmailIdNative(String emailId);

    //Native Named Param
    @Query(value = "SELECT * FROM tbl_student WHERE email_address = :emailId", nativeQuery = true)
    Student getStudentsByEmailIdNativeNamedParam(@Param("emailId") String emailId);

    //when updating data in the database using any method  annotate it with @Modifying annotation
    //to make it transactional use @Transactional annotation
    @Modifying
    @Transactional
    @Query(value = "UPDATE tbl_student SET first_name = :firstName where email_address = :emailId", nativeQuery = true)
    int updateFirstNameByEmailId(@Param("firstName") String firstName,@Param("emailId") String emailId);
}
