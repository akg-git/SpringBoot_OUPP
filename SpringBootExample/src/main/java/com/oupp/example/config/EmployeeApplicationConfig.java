/*	Wherever new dependency in application throws an error: it is not identifiable or it instructs to create this dependency as bean 
 * then create a ApplicationConfig java file
 * and create a bean with that respective dependency
	*/

package com.oupp.example.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
