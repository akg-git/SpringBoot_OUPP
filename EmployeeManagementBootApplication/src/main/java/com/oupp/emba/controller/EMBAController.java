package com.oupp.emba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.oupp.emba.entity.EmployeeEntity;
import com.oupp.emba.services.EmbaServiceImpl;

import jakarta.servlet.http.HttpSession;

//import com.oupp.emba.entity.EmployeeEntity;
//import com.oupp.emba.services.EmbaServiceImpl;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class EMBAController {
//	
//	@Autowired
//	private EmbaServiceImpl embaService;
//	
//	@GetMapping("/")
//	public String index(Model model) {
//		List<EmployeeEntity> empList = embaService.getAllEmployees();
//		/* empList: List object
//		 * employeeLuist: model name (mentioned in  HTML file)*/
//		model.addAllAttributes(empList);
//		return "index";
//	}
//	
//	@GetMapping("/save")
//	public String embaSave() {
//		
//		return "emba_save";
//	}
//	
//	@PostMapping("/save")
//	public String saveEmba(@ModelAttribute EmployeeEntity emp, HttpSession session) {
//		EmployeeEntity employeeEntity = embaService.saveEmployee(emp);
//		if( employeeEntity != null) {
//			session.setAttribute("msg", "Registered successfull");
//		}
//		else {
//			session.setAttribute("msg", "Unable to register");
//		}
//		return "redirect:/save";
//	}
//	
//	@GetMapping("/edited")
//	public String embaEdit() {
//		
//		return "emba_edit";
//	}
//	
//	@PostMapping("/updated")
//	public String updateEmba(@ModelAttribute EmployeeEntity emp, HttpSession session) {
//		EmployeeEntity employeeEntity = embaService.saveEmployee(emp);
//		if( employeeEntity != null) {
//			session.setAttribute("msg", "Updated successfull");
//		}
//		else {
//			session.setAttribute("msg", session);
//		}
//		return "redirect:/updateEmployee";
//	}
//	
//	@GetMapping("/delete")
//	public String embaDelete() {
//		
//		return "emba_delete";
//	}
//	
//	@PostMapping("/deleted")
//	public String deleteEmba(@ModelAttribute EmployeeEntity emp, HttpSession session) {
//		EmployeeEntity employeeEntity = embaService.saveEmployee(emp);
//		if( employeeEntity != null) {
//			session.setAttribute("msg", "Updated successfull");
//		}
//		else {
//			session.setAttribute("msg", session);
//		}
//		return "redirect:/deleteEmployee";
//	}
//	
//
//}




@Controller
public class EMBAController {
	
	@Autowired
	EmbaServiceImpl employeeService;
	
	@GetMapping("/")
	public String index(Model model)
	{
		List<EmployeeEntity> list=employeeService.getAllEmployees();
		model.addAttribute("empList",list);
		return "index";
	}
	
	@GetMapping("/empSave")
	public String empSave()
	{
		return "emp_save";
	}
	@GetMapping("/editEmp")
	public String editEmp()
	{
		return "edit_emp";
	}
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute EmployeeEntity emp,HttpSession session)
	{
		
		EmployeeEntity employee=employeeService.saveEmployee(emp);
		
		if(employee!=null)
		{
			//System.out.println("save success");
			session.setAttribute("msg","Register successfully");
		}
		else
		{
			//System.out.println("Something wrong on server");
			session.setAttribute("msg", "something wrong on server");
		}
		
		
		return "redirect:/empSave";
	}
	
	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable int id, Model m)
	{
		EmployeeEntity emp=employeeService.getById(id);
		m.addAttribute("emp",emp);
		return "edit_emp";
	}
	
	@PostMapping("/updateEmpDtls")
	public String updateEmp(@ModelAttribute EmployeeEntity emp,HttpSession session)
	{
		
		EmployeeEntity updateEmp=employeeService.saveEmployee(emp);
		
		if(updateEmp!=null)
		{
			//System.out.println("save success");
			session.setAttribute("msg","Update successfully");
		}
		else
		{
			//System.out.println("Something wrong on server");
			session.setAttribute("msg", "something wrong on server");
		}
		
		
		return "redirect:/";
	}



}



