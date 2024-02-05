package com.oupp.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oupp.example.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
