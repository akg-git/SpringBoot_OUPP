package com.oupp.bank.service;

import java.util.List;

import com.oupp.bank.entity.Account;
import com.oupp.bank.entity.User;



public interface AccountService {	
	
	public Account createAccount(Account account);
	public Account updatePerson(Long id, Account updatePerson);
	public String deleteAccount(Long id);
	
	public List<Account> searchPersonsByName(String name);
	
	public List<Account> searchPersonsByNameAndAge(String name, int age);
	
	public List<Account> findPersonsByAgeBetween(int minAge, int maxAge);
	public User getUserById(Long id);
	public User createUser(User user);
	public User updateUser(Long id, User updateUser);
	public void deleteUser(Long id);

}
