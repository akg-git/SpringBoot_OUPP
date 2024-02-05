package com.oupp.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oupp.example.entity.Employee;
import com.oupp.example.repository.EmployeeRepository;
import com.oupp.example.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired 
	private EmployeeRepository employeeRepository;
	
	//mapping model
	@Autowired
	ModelMapper modelMapper;
	
	//my user-defined methods
	public EmployeeResponse getEmployeeById(int id) {
		Employee employee = employeeRepository.findById(id).get();
		EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
		return employeeResponse;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}
	
	
	
}
