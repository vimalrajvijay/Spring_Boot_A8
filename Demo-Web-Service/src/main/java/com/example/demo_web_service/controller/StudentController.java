package com.example.demo_web_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/students")
public class StudentController {

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String saveStudent() {
		return "Hello";
	}
//	@PutMapping("/101")
//	public void updateStudent() {
//		
//	}
	
	@GetMapping("/api/students/{id}/{name}")
	public String readDataFromUrlPath(@PathVariable(value = "id") int stuId,@PathVariable String name) {
		return "Student id : " + stuId+", name : "+name;
	}
	
	@GetMapping("/api/students")
	public String readDataFromQueryString(@RequestParam(value = "id") int stuId,@RequestParam String name) {
		return "Student id : " + stuId+", name : "+name;
	}
	
	@PostMapping("/api/students")
	public Student readDataFromBody(@RequestBody Student student) {
		return student;
	}
	
	@GetMapping("/api/students/{id}")
	public ResponseEntity<String> findStudent(@PathVariable int id) {
		
		List<Integer> ids = List.of(101, 102, 103);
		
		if(ids.contains(id))
			return new ResponseEntity<>("Student Found", HttpStatus.OK);
		else
			return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
		
	}
}
