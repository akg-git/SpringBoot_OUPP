package com.oupp.bank.service;

import java.util.List;
import java.util.Optional;

import com.oupp.bank.entity.User;

public interface UserService {

	User createUser(User user);

	String deleteUser(Long userId);

	User updateUser(Long id, User updateUser);

	User getUserById(Long id);

	List<User> getAllUsers();

}
