package com.oupp.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oupp.bank.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByUserId(String name);

	/*
	 * List<User> findByNameContainingIgnoreCaseAndAge(String name, int age);
	 * 
	 * // JPQL query to find persons by age between a specified range
	 * 
	 * @Query("SELECT p FROM User p WHERE p.age BETWEEN :minAge AND :maxAge")
	 * List<User> findUsersAgeBetween(@Param("minAge") int minAge, @Param("maxAge")
	 * int maxAge);
	 */

}
