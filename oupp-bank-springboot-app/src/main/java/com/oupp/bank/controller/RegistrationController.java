/**
 * 
 */
package com.oupp.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oupp.bank.entity.User;
import com.oupp.bank.service.impl.UserServiceImpl;

/**
 * @author group-8
 */

@RestController
//class level url-pattern
@RequestMapping("/user")
public class RegistrationController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping
	public List<User> getAllUser() {
		return userServiceImpl.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userServiceImpl.getUserById(id)
				.orElseThrow(() -> new IllegalArgumentException(" Person not found with id = "+id));
	}
	
	@PostMapping
	public User createUser(@RequestBody User user ) {
		return userServiceImpl.createUser(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User updateUser) {
		return userServiceImpl.updateUser(id, updateUser);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		userServiceImpl.deleteUser(id);
		return "User having id = "+id+" is deleted.";
	}
	
	

}
