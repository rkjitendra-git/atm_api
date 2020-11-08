package com.learning.atm.service;

import com.learning.atm.model.Account;

public interface IATMService {

	double checkBalance(int accountNumber) throws Exception;

	String withdraw(int accountNumber, int amount)throws Exception;

	String deposit(int accountNumber, int amount)throws Exception;
	
	void createAccount(Account account)throws Exception;

}
