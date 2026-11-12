package com.example.demo_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo_springboot.entity.Student;

@Controller
public class TestController {

	@PostMapping("/register")
	public String readFormData(@ModelAttribute Student student, Model model) {
		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("email", student.getEmail());
		return "display.html";
	}
}
