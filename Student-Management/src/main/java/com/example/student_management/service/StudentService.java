package com.example.student_management.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.student_management.dto.StudentRequestDTO;
import com.example.student_management.dto.StudentResponseDTO;
import com.example.student_management.dto.StudentV1ResponseDTO;
import com.example.student_management.dto.StudentV2ResponseDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.InvalidAgeException;
import com.example.student_management.repository.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	private ModelMapper modelMapper;
	
	public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
		this.studentRepository = studentRepository;
		this.modelMapper = modelMapper;
	}

	public StudentResponseDTO saveStudent(StudentRequestDTO requestDTO) {
//		if(requestDTO.getAge()<18)
//			throw new InvalidAgeException("Age is less than 18");
		
//		Student student = new Student();
//		student.setName(requestDTO.getName());
//		student.setEmail(requestDTO.getEmail());
//		student.setAge(requestDTO.getAge());
//		student.setPassword(requestDTO.getPassword());
		
		Student student = modelMapper.map(requestDTO, Student.class);
		
		Student savedStudent = studentRepository.save(student);
		
//		StudentResponseDTO responseDTO = new StudentResponseDTO();
//		responseDTO.setName(savedStudent.getName());
//		responseDTO.setEmail(savedStudent.getEmail());
//		responseDTO.setAge(savedStudent.getAge());
		
		StudentResponseDTO responseDTO
		= modelMapper.map(savedStudent, StudentResponseDTO.class);
		
		return responseDTO;
	}
	
	public StudentV1ResponseDTO getStudentV1(int id) {
		Student student = studentRepository.findById(id).get();	
		return modelMapper.map(student, StudentV1ResponseDTO.class);
	}
	
	public StudentV2ResponseDTO getStudentV2(int id) {
		Student student = studentRepository.findById(id).get();	
		return modelMapper.map(student, StudentV2ResponseDTO.class);
	}
	
	public List<StudentResponseDTO> getAllStudentsByName(String name){
		List<Student> students = studentRepository.findStudents(name);
		List<StudentResponseDTO> responseDTOs = new ArrayList<>();
		for(Student student : students) {
			responseDTOs.add(modelMapper.map(student
					, StudentResponseDTO.class));
		}
		return responseDTOs;
	}
	
	public Page<Student> getAllStudent(Pageable pageable){
		return studentRepository.findAll(pageable);
	}
}
