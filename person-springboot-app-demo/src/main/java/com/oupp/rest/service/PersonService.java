package com.oupp.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oupp.rest.entity.Person;
import com.oupp.rest.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	
	public Optional<Person> getPersonById(Long id){
		return personRepository.findById(id);
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person updatePerson(Long id, Person updatePerson) {
		return personRepository.findById(id)
				.map(person -> {
					person.setName(updatePerson.getName());
					person.setAge(updatePerson.getAge());
					return personRepository.save(person);
				}).orElseThrow(
				()	-> new IllegalArgumentException("No person is found with id = "+id));	
	}
	
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
	
	public List<Person> searchPersonsByName(String name){
		//Implement the logic for searching person by name
		
		return personRepository.findByNameContainingIgnoreCase(name);
	}
	
	public List<Person> searchPersonsByNameAndAge(String name, int age){
		//Implement the logic for searching person by name
		
		return personRepository.findByNameContainingIgnoreCaseAndAge(name, age);
	}
	
	public List<Person> findPersonsByAgeBetween(int minAge, int maxAge){
		return personRepository.findPersonsAgeBetween(minAge, maxAge);
	}
	
}
