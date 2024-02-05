package com.oupp.emba.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oupp.emba.entity.EmployeeEntity;
import com.oupp.emba.repository.EmbaRepository;

@Service
public class EmbaServiceImpl implements EmbaService{

	@Autowired
	private EmbaRepository embaRepository;
	
	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity emp) {
		EmployeeEntity empe =  embaRepository.save(emp);
		return empe;
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() {
		
		return embaRepository.findAll();
	}

	@Override
	public EmployeeEntity getById(int id) {
		
		return embaRepository.findById(id).get();
	}

	@Override
	public String deleteEmployee(int id) {
		EmployeeEntity empId = embaRepository.findById(id).get();
		if(empId!=null) {
			embaRepository.delete(empId);
			return "Employee with Id: "+empId+"left the organization.";
		}
		return "Deletion Error: Employee with Id: "+empId+"not deleted.";
	}

}
