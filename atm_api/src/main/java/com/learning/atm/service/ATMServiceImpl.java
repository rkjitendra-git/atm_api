package com.learning.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.atm.model.Account;
import com.learning.atm.repository.ATMRepository;

@Service
public class ATMServiceImpl implements IATMService {
	
	@Autowired
	ATMRepository atmRepository;

	

	@Override
	public void createAccount(Account account) {
		atmRepository.save(account);
	}

	@Override
	public double checkBalance(int accountNumber) throws Exception {
		return findAccount(accountNumber).getBalance();
	}

	@Override
	public String withdraw(int accountNumber, int amount) throws Exception {
		double balance = checkBalance(accountNumber);
        if (balance >= amount) {
            Account account = findAccount(accountNumber);
            if (account!=null) {
			double remainBalance=balance-amount;
            account.setBalance(remainBalance);
            createAccount(account);
            return ("withdraw success, balance in your account = "+remainBalance);
            }
            else{
            	return ("Not valid account number !.");
            }
        } else {
            return ("There is not enough balance in your account.");
        }
		
	}

	@Override
	public String deposit(int accountNumber, int amount) throws Exception {
        if (accountNumber >= 0) {
            Account account = findAccount(accountNumber);
            if (account!=null) {
			double totalBalance=account.getBalance()+amount;
            account.setBalance(totalBalance);
            createAccount(account);
            return ("deposited successfully, balance in your account = "+totalBalance);
            }
            else{
            	return ("Not valid account number !.");
            }
        } else {
        	return ("Not valid account number !.");
        }
	}
	
	public Account findAccount(int accountNumber) {
		if(atmRepository.existsById(accountNumber))
		return atmRepository.findById(accountNumber).get();
		else 
			throw new RuntimeException("Invalid Account number");
	}
	
	public void updateAccount(Account account, int accountNumber) {
		atmRepository.save(account);
	}
}