package com.learning.atm.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.atm.model.Account;
import com.learning.atm.service.ATMServiceImpl;

@RestController
public class AccountController {

	@Autowired
	ATMServiceImpl atmServices;

	@GetMapping("/checkBalance/{accountNumber}")
	private String  checkBalance(@PathVariable("accountNumber") int accountNumber) throws Exception {
		return "Available balance in your account is INR "+atmServices.checkBalance(accountNumber);
	}

	@PostMapping("/createAccount")
	private String createAccount(@RequestBody Account account) {
		atmServices.createAccount(account);
		return "Account created succesfully ! Account Number is " + account.getAccountNumber();
	}

	@PutMapping("/withdraw/{accountnumber}/{amount}")
	public @ResponseBody String withdraw(@PathVariable(value = "accountnumber") int accountNumber,
			@PathVariable(value = "amount") int amount) throws Exception {

		return atmServices.withdraw(accountNumber, amount);

	}
	
	@PutMapping("/deposit/{accountnumber}/{amount}")
	public @ResponseBody String deposit(@PathVariable(value = "accountnumber") int accountNumber,
			@PathVariable(value = "amount") int amount) throws Exception {

		return atmServices.deposit(accountNumber, amount);

	}

}
