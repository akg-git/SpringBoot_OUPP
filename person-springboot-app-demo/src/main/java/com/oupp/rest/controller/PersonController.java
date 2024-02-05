package com.oupp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oupp.rest.entity.Person;
import com.oupp.rest.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	
//	@GetMapping("/details")
//	public String getAllPersons(){
//		return "/person-springboot-app-demo/src/main/webapp/pages/person.jsp";
//	}
	
	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable Long id) {
		return personService.getPersonById(id)
				.orElseThrow(() -> new IllegalArgumentException(" Person not found with id = "+id));
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person ) {
		return personService.createPerson(person);
	}
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person updatePerson) {
		return personService.updatePerson(id, updatePerson);
	}
	
	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
		return "Person having id = "+id+" is deleted.";
	}
	
	@GetMapping("/search")
	public List<Person> searchPersonsByNameAndAge(
		@RequestParam(name = "name") String name,
		@RequestParam(name = "age") int age){
		return personService.searchPersonsByNameAndAge(name, age);
	}
	@GetMapping("/searchByName")
	public List<Person> searchPersonsByName(
			@RequestParam(name = "name") String name){
		return personService.searchPersonsByName(name);
	}
	@GetMapping("/searchByAge")
	public List<Person> findPersonsByAgeBetween(
			@RequestParam(name = "minAge") int minAge,
		@RequestParam(name = "maxAge") int maxAge){
		return personService.findPersonsByAgeBetween(minAge, maxAge);
	}
	
	
	
}
