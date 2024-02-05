package com.oupp.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oupp.bank.entity.User;
import com.oupp.bank.service.AccountService;

@RestController
//class level url-pattern
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
//	@GetMapping("/{id}")
//	public User getUserById(@PathVariable Long id) {
//		return accountService.getUserById(id)
//				.
//	}
	
	@PostMapping
	public User createUser(@RequestBody User user ) {
		return accountService.createUser(user);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User updateUser) {
		return accountService.updateUser(id, updateUser);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		accountService.deleteUser(id);
		return "User having id = "+id+" is deleted.";
	}

}
