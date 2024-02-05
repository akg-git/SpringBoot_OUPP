package com.oupp.bank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.oupp.bank.entity.User;
import com.oupp.bank.repository.UserRepository;
import com.oupp.bank.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(Long userId) {
		
		userRepository.deleteById(userId);
		return "User with id = "+userId+" deleted.";
	}

	@Override
	public User updateUser(Long id, User updateUser) {

		return userRepository.findById(id)
				.map(usr -> {
					usr.setName(updateUser.getName());
					usr.setEmail(updateUser.getEmail());
					usr.setPassword(updateUser.getPassword());
					usr.setMobileNumber(updateUser.getMobileNumber());
					usr.setAddress(updateUser.getAddress());
					usr.setAadharId(updateUser.getAadharId());
				})
				.orElseThrow( ()-> new IllegalArgumentException("No User is found with id = "+id));
	}

	@Override
	public User getUserById(Long id) {

		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
