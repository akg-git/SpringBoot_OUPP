package com.techm.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techm.mvc.entity.User;
import com.techm.mvc.repository.UserRepository;


@Controller
@RequestMapping("/users")
/* class level url pattern: /users */
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@GetMapping
	private String listUser(Model model) {
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "user/list";
	}

	/* Local level /create will append with class level url-pattern */
	@GetMapping("/create")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user/create";
	}
	
	@PostMapping("/create")
	public String createUser(@ModelAttribute User user) {
		userRepository.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/edit/{id}")
	public String editUserForm(@PathVariable Long id, Model model) {
	User user = userRepository.findById(id)
	.orElseThrow(() ->
	new IllegalArgumentException("Invalid user id:" + id));
	model.addAttribute("user",user);
	return "user/edit";
	}

	@PostMapping("/edit/{id}")
	public String editUser(@PathVariable Long id,@ModelAttribute User updateUser) {
	userRepository.findById(id)
	.ifPresent(user->{
	user.setFirstName(updateUser.getFirstName());
	user.setLastName(updateUser.getLastName());
	user.setAge(updateUser.getAge());
	userRepository.save(user);
	});
	return "redirect:/users";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "redirect:/users";
	}
	
}
