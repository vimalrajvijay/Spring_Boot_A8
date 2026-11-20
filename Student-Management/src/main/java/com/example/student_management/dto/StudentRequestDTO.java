package com.example.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
	@NotBlank(message = "Name should not be null or empty or blank")
	private String name;
	@Email(message = "Enter valid Email")
	private String email;
	@Positive(message="Age cannot be Negative")
	@Min(18)
	private int age;
	@Size(min=8, max=16)
	private String password;
}
