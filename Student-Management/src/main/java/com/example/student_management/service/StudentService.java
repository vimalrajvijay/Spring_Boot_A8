package com.example.student_management.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.student_management.dto.StudentRequestDTO;
import com.example.student_management.dto.StudentResponseDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.InvalidAgeException;
import com.example.student_management.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public StudentResponseDTO saveStudent(StudentRequestDTO requestDTO) {
		if(requestDTO.getAge()<18)
			throw new InvalidAgeException("Age is less than 18");
		
		Student student = new Student();
		student.setName(requestDTO.getName());
		student.setEmail(requestDTO.getEmail());
		student.setAge(requestDTO.getAge());
		student.setPassword(requestDTO.getPassword());
		
		Student savedStudent = studentRepository.save(student);
		
		StudentResponseDTO responseDTO = new StudentResponseDTO();
		responseDTO.setName(savedStudent.getName());
		responseDTO.setEmail(savedStudent.getEmail());
		responseDTO.setAge(savedStudent.getAge());
		
		return responseDTO;
	}
}
