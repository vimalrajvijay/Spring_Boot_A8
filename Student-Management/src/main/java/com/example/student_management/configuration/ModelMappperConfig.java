package com.example.student_management.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappperConfig {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
