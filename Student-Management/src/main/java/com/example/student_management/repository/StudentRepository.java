package com.example.student_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.student_management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	//@Query("select s from Student s where s.name=:name")
	@Query(value = "select * from student where name = :name", nativeQuery = true)
	List<Student> findStudents(String name);
}
