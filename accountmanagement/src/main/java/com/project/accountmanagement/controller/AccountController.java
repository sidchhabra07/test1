package com.project.accountmanagement.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;

import java.util.HashMap;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.accountmanagement.entity.AccountTransaction;
import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.exception.ValueNotFoundException;
import com.project.accountmanagement.service.AccountService;
import com.project.accountmanagement.service.AccountService;
import com.project.accountmanagement.service.ManagerService;

// This is a AccountController file
@RestController
public class AccountController {
	@Autowired
	private AccountService accountservice;
	
	
	@GetMapping("/statement/{accountnumber}")
	public List<AccountTransaction> getStatementsByAccountId(@PathVariable long accountnumber) throws ValueNotFoundException{

		return accountService.getStatementsByAccountId(accountnumber);
}

	
	@PostMapping("/deposit")
	public AccountTransaction newTransactionByDeposit(@RequestParam(value="amount") long amount,
			@RequestParam(value="accountnumber") long accountnumber){
		
		return accountservice.depositamount(amount,accountnumber);
	}
	
	@PostMapping("/withdrawal")
	public AccountTransaction newTransactionByWithdrawal(@RequestParam(value="amount") long amount,
			@RequestParam(value="accountnumber") long accountnumber){
		
		return accountservice.withdrawamount(amount,accountnumber); 

	}
	
	@GetMapping("/statements/{date}")
	public List<AccountTransaction> getStatementsByDate(@PathVariable String date){
		
		return accountService.getStatementsByDate(date);
	}

	@PostMapping("/transfer")
	public AccountTransaction newTransactionByTransfer(@RequestParam(value="amount") int amount,
		@RequestParam(value="accountnumber1") int accountnumber1, @RequestParam(value="accountnumber2") int accountnumber2){

		return accountservice.transferamount(amount,accountnumber1,accountnumber2);
	}

	@GetMapping("/accounts/{id}")
	public Set<HashMap<String,String>> getAccountsByCustomerId(@PathVariable long id){
	
		
    return accountservice.getAccountdetaisByCustomerId(id);
			
	}
	
}
