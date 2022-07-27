package com.project.accountmanagement.controller;

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
import com.project.accountmanagement.exception.ValueNotFoundException;
import com.project.accountmanagement.service.AccountService;

/**
 * AccountController(This is responsible for handling all the REST APIs related to customer)
 * @author srapu
 *
 */
@RestController
public class AccountController {
	@Autowired
	private AccountService accountservice;
	
	
	/**
	 * This is the REST API call for getting all the transaction statements of given accountnumber
	 * @param accountnumber
	 * @return
	 * @throws ValueNotFoundException
	 */
	@GetMapping("/statement/{accountnumber}")
	public List<AccountTransaction> getStatementsByAccountId(@PathVariable long accountnumber)
			throws ValueNotFoundException {

		return accountservice.getStatementsByAccountId(accountnumber);
	}
	
	/**
	 * This is the REST API call for making the new transaction by depositing money in given accountnumber 
	 * @param amount
	 * @param accountnumber
	 * @return
	 * @throws ValueNotFoundException
	 */
	@PostMapping("/deposit")
	public AccountTransaction newTransactionByDeposit(@RequestParam(value = "amount") long amount,
			@RequestParam(value = "accountnumber") long accountnumber) throws ValueNotFoundException {

		return accountservice.depositamount(amount, accountnumber);
	}
	
	/**
	 * This is the REST API call for making the new transaction by withdrawing money from given account number 
	 * @param amount
	 * @param accountnumber
	 * @return
	 * @throws ValueNotFoundException
	 */
	@PostMapping("/withdrawal")
	public AccountTransaction newTransactionByWithdrawal(@RequestParam(value = "amount") long amount,
			@RequestParam(value = "accountnumber") long accountnumber) throws ValueNotFoundException {

		return accountservice.withdrawamount(amount, accountnumber);

	}
	
	/**
	 * This is the REST API call for making the new transaction by transferring money from one customer account to another customer/self account
	 * @param amount
	 * @param accountnumber1
	 * @param accountnumber2
	 * @return
	 * @throws ValueNotFoundException
	 */
	@PostMapping("/transfer")
	public AccountTransaction newTransactionByTransfer(@RequestParam(value = "amount") int amount,
			@RequestParam(value = "accountnumber1") int accountnumber1,
			@RequestParam(value = "accountnumber2") int accountnumber2) throws ValueNotFoundException {

		return accountservice.transferamount(amount, accountnumber1, accountnumber2);
	}
	
	/**
	 * This is the REST API call for getting transaction statements made on particular date
	 * @param date
	 * @return
	 */
	@GetMapping("/statements/{date}")
	public List<AccountTransaction> getStatementsByDate(@PathVariable String date) {
		return accountservice.getStatementsByDate(date);
	}
	
	/**
	 * This is the REST API call for retrieving all the accounts owned by given Customer Id
	 * @param customerid
	 * @return
	 */
	@GetMapping("/accounts/{customerid}")
	public Set<HashMap<String, String>> getAccountsByCustomerId(@PathVariable long customerid) {
		return accountservice.getAccountdetaisByCustomerId(customerid);

	}
	
	/**
	 * This is the REST API call for getting five most recent transaction statements made with given account number
	 * @param accountid
	 * @return
	 * @throws ValueNotFoundException
	 */
	@GetMapping("/transactions/{accountid}")
	public List<AccountTransaction> getTopTransactionsByAccountId(@PathVariable long accountid) throws ValueNotFoundException{
		return accountservice.getTopTransactionsByAccountId(accountid);

	}

}