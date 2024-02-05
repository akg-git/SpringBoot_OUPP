/**
 * 
 */
package com.oupp.bank.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * GROUP-8
 */

@Entity
public class Account {
	@Id
	private Long accountId;

	private float balance;
	private String statement;

	// constructor

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Long accountId, float balance, String statement) {
		super();
		this.accountId = accountId;
		this.balance = balance;
		this.statement = statement;
	}

	// getters and setters
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

}
