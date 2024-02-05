package com.techm.mvc.service;

import java.util.List;

import com.techm.mvc.entity.User;

public interface UserService {
	
	User createUser(User user);
	
	User getUserById(Long userId);
	
	List<User> getAllUsers();
	
	User updatedUser(User user);
	
	void deleteUser(Long userId);

}
