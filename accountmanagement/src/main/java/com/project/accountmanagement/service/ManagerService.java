package com.project.accountmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.accountmanagement.AccountmanagementApplication;
import com.project.accountmanagement.entity.BankAccount;
import com.project.accountmanagement.entity.Customer;
import com.project.accountmanagement.entity.Users;
import com.project.accountmanagement.repository.BankAccountRepository;
import com.project.accountmanagement.repository.CustomerRepository;
import com.project.accountmanagement.repository.UsersRepository;

/**
 * ManagerService(This class is responsible for handling manager business logic and being a layer service)
 * @author srapu
 *
 */
@Service
public class ManagerService {
	/**
	 * These are the repository instances of BankAccountRepository,CustomerRepository,UsersRepository
	 */
	@Autowired
	private CustomerRepository customerrepository;
	@Autowired
	private BankAccountRepository bankaccountrepository;
	@Autowired
	private UsersRepository usersrepository;
	
	/**
	 * Implemented slf4j Logging feature 
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(AccountmanagementApplication.class);
	
		/**
		 * createCustomer(This method is used to create new customer profile if no customer exists with given pan number)
		 * @param customer
		 * @return
		 */
		public Customer createCustomer(Customer customer) {
			String pancard= customer.getPanNumber();
			
			if(customerrepository.getByPanNumber(pancard) ==null) {
				customerrepository.save(customer);
				
			}
			Customer customer1=customerrepository.getByPanNumber(pancard);
			createAccount(customer1.getcId());
			createUser(customer1.getcId());
			return customer1;
		}
		/**
		 * This method is used to add log in credentials for the newly added customer
		 * Logger.info is implemented
		 
		 * @param custid
		 */
		private void createUser(long custid) {
			Users user=new Users();
			user.setRoleId(2);
			user.setPassword("Default@Change");
			user.setUserId((int)custid);
			usersrepository.save(user);	
			LOGGER.info("user account stored");
		}
		/**
		 * This method is used to create new bank account for the given customer id
		 * Logger.info is implemented
		 * @param custid
		 */
		public void createAccount(long custid) {
			BankAccount bankaccount= new BankAccount();
			bankaccount.setCustomerId(custid);
			bankaccountrepository.save(bankaccount);
			LOGGER.info("bank account stored");
		}
		
		
	
}
