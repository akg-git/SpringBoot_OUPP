package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.Account;
import com.user.model.User;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByUser(User user);
    // Additional custom queries if needed
}

