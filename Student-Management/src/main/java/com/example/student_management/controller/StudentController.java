package com.example.student_management.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_management.dto.StudentRequestDTO;
import com.example.student_management.dto.StudentResponseDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<StudentResponseDTO> createStudent(
			@RequestBody StudentRequestDTO requestDTO){
		StudentResponseDTO savedStudent = studentService.saveStudent(requestDTO);
		return new ResponseEntity<>( savedStudent, HttpStatus.OK);
	}

	@GetMapping("/{name}")
	public ResponseEntity<List<StudentResponseDTO>> 
	          findAllStudentsByName(@PathVariable String name){
		List<StudentResponseDTO> dtos 
		     = studentService.getAllStudentsByName(name);
		return new ResponseEntity<>( dtos, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent(Pageable pageable){
		Page<Student> page = studentService.getAllStudent(pageable);
		return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
	}
}
