package com.project.accountmanagement.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.accountmanagement.AccountmanagementApplication;
import com.project.accountmanagement.entity.AccountTransaction;
import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.exception.ValueNotFoundException;
import com.project.accountmanagement.repository.AccountTransactionRepository;
import com.project.accountmanagement.repository.BankAccountRepository;

/**
 * ManagerService(This class is responsible for handling customer business logic and being a layer service)
 * @author srapu
 *
 */
@Service
public class AccountService {

	/**
	 * These are the repository instances of BankAccountRepository,AccountTransactionRepository
	 */
	@Autowired
	private BankAccountRepository bankaccountrepository;

	@Autowired
	private AccountTransactionRepository accounttransactionrepository;
	
	/**
	 * Implemented slf4j Logging feature 
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(AccountmanagementApplication.class);

	/**
	 * This method is used to deposit money in the customer given account
	 * @author srapu
	 * @param amount
	 * @param accountnumber
	 * @return
	 */
	public AccountTransaction depositamount(long amount, long accountnumber) {
		BankAccount balance = bankaccountrepository.getByAccountNumber(accountnumber);
		if (balance == null) {
			throw new ValueNotFoundException("ACCOUNT NUMBER YOU ENETRED IS INCORRECT. " + accountnumber);
		}
		balance.setCurrentBalance(balance.getCurrentBalance() + amount);
		bankaccountrepository.setAccountBalance(balance.getCurrentBalance(), accountnumber);

		Random random = new Random();

		AccountTransaction transaction = new AccountTransaction();
		transaction.setAccountNumber(accountnumber);
		transaction.setCurrentBalane(balance.getCurrentBalance());
		transaction.setType("Credit");
		transaction.setSubType("Cash");
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionId(random.nextInt(100000));

		accounttransactionrepository.save(transaction);

		return transaction;
	}

	/**
	 * This method is used to withdraw money from customer account
	 * @param amount
	 * @param accountnumber
	 * @return
	 * @throws ValueNotFoundException
	 */
	public AccountTransaction withdrawamount(long amount, long accountnumber) throws ValueNotFoundException {
		BankAccount balance = bankaccountrepository.getByAccountNumber(accountnumber);
		if (balance == null) {
			throw new ValueNotFoundException("ACCOUNT NUMBER YOU ENETRED IS INCORRECT. " + accountnumber);
		}
		if (balance.getCurrentBalance() < amount) {
			throw new ValueNotFoundException(
					"Withdrawal amount is greater than current balance. Your current balance is "
							+ balance.getCurrentBalance());
		}
		balance.setCurrentBalance(balance.getCurrentBalance() - amount);
		bankaccountrepository.setAccountBalance(balance.getCurrentBalance(), accountnumber);

		Random random = new Random();
		AccountTransaction transaction = new AccountTransaction();
		transaction.setAccountNumber(accountnumber);
		transaction.setCurrentBalane(balance.getCurrentBalance());
		transaction.setType("Debit");
		transaction.setSubType("Cash");
		LocalDate date = LocalDate.now();
		transaction.setTransactionDate(date);
		transaction.setTransactionId(random.nextInt(100000));

		accounttransactionrepository.save(transaction);

		return transaction;
	}
	
	/**
	 * This method is used transfer amount from one customer bank account to another customer/self bank account
	 * @param amount
	 * @param accountnumber1
	 * @param accountnumber2
	 * @return
	 * @throws ValueNotFoundException
	 */
	public AccountTransaction transferamount(long amount, long accountnumber1, long accountnumber2)
			throws ValueNotFoundException {
		BankAccount balance1 = bankaccountrepository.getByAccountNumber(accountnumber1);
		if (balance1 == null) {
			throw new ValueNotFoundException("Entered Valid sender account number");
		}
		if (balance1.getCurrentBalance() < amount) {
			throw new ValueNotFoundException(
					"Withdrawal amount is greater than current balance. Your current balance is "
							+ balance1.getCurrentBalance());
		}
		balance1.setCurrentBalance(balance1.getCurrentBalance() - amount);
		BankAccount balance2 = bankaccountrepository.getByAccountNumber(accountnumber2);
		if (balance2 == null) {
			throw new ValueNotFoundException("Entered Valid receivers account number");
		}
		balance2.setCurrentBalance(balance2.getCurrentBalance() + amount);
		bankaccountrepository.setAccountBalance(balance1.getCurrentBalance(), accountnumber1);
		bankaccountrepository.setAccountBalance(balance2.getCurrentBalance(), accountnumber2);

		Random random = new Random();

		AccountTransaction transaction = new AccountTransaction();
		transaction.setAccountNumber(accountnumber1);
		transaction.setCurrentBalane(balance1.getCurrentBalance());
		transaction.setType("Debit");
		transaction.setSubType("Transfer");
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionId(random.nextInt(100000));

		accounttransactionrepository.save(transaction);

		return transaction;
	}
	
	/**
	 * This method is used to get details of accounts owned by given customer
	 * @param custid
	 * @return
	 */
	public Set<HashMap<String, String>> getAccountdetaisByCustomerId(long custid) {
		Set<HashMap<String, String>> finalaccounts = new HashSet<HashMap<String, String>>();
		Optional<List<BankAccount>> bankaccount = bankaccountrepository.findCustomerByCustomerId(custid);

		if (bankaccount.isPresent()) {
			for (BankAccount account : bankaccount.get()) {
				HashMap<String, String> accdetails = new HashMap<String, String>();
				accdetails.put("Account number", Long.toString(account.getAccountNumber()));
				accdetails.put("Current balance", Long.toString(account.getCurrentBalance()));
				finalaccounts.add(accdetails);
			}
		}

		return finalaccounts;
	}
	
	/**
	 * This method is used to get the transaction statements made by the given account number
	 * @param accountId
	 * @return
	 * @throws ValueNotFoundException
	 */
	public List<AccountTransaction> getStatementsByAccountId(long accountId) throws ValueNotFoundException {
		if (!bankaccountrepository.findById(accountId).isPresent()) {
			throw new ValueNotFoundException("Entered account number is incorrect" + accountId);
		}

		List<AccountTransaction> result = accounttransactionrepository.findByAccountNumber(accountId);

		if (result.isEmpty()) {
			throw new ValueNotFoundException("No transactions were made by this account" + accountId);
		}
		return result;
	}
	
	/**
	 * This method is used to retrieve transaction statements made on give date
	 * @param date
	 * @return
	 */
	public List<AccountTransaction> getStatementsByDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formatter = formatter.withLocale(Locale.CANADA);
		LocalDate date1 = LocalDate.parse(date, formatter);
		LOGGER.info("---------------exception try-----------------");
		List<AccountTransaction> result = accounttransactionrepository.getByTransactionDate(date1);
		return result;

	}
	
	/**
	 * This method is used to get five most recent transaction statements made with given account number
	 * @param accountid
	 * @return
	 */
	public List<AccountTransaction> getTopTransactionsByAccountId(long accountid) {
		BankAccount balance1 = bankaccountrepository.getByAccountNumber(accountid);
		if (balance1 == null) {
			throw new ValueNotFoundException("Entered Valid account number");
		}
		List<AccountTransaction> result = accounttransactionrepository.findTop5ByOrderByTransactionDateDesc(accountid);
		if (result.isEmpty()) {
			throw new ValueNotFoundException("No transactions were made by this account number " + accountid);
		}
		return result;
	}
}
