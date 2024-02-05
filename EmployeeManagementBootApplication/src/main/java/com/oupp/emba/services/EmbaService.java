package com.oupp.emba.services;

import java.util.List;

import com.oupp.emba.entity.EmployeeEntity;

public interface EmbaService {

	public EmployeeEntity saveEmployee(EmployeeEntity emp);
	public List<EmployeeEntity> getAllEmployees();
	public EmployeeEntity getById(int id);
	public String deleteEmployee(int id);
	
}
