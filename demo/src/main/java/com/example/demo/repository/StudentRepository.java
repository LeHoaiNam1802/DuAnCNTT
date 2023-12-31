package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
    @Query(value = "select max(id) from Student ")
    String maxStudentId();

    Student findByUserId(Long userId);

    List<Student> findStudentByGiaoVienId(String giaoVienId);

    @Query(value = "select s from Student s where s.name like %:name%", nativeQuery = true)
    List<Student> findByName(@Param("name") String name);
}
