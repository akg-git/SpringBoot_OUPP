package com.oupp.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oupp.bank.entity.User;

public interface AccountRepository extends JpaRepository<User, Long>{
	
}
