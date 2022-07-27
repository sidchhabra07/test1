package com.project.accountmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.accountmanagement.entity.Customer;
import com.project.accountmanagement.service.ManagerService;
/**
 * ManagerController(This is responsible for handling all the REST APIs related to manager)
 * @author srapu
 *
 */
@RestController
public class ManagerController {
	/**
	 * managerservice
	 * Creating instance for ManagerService
	 */
	@Autowired
	private ManagerService managerservice;
	
	/**
	 *  createCustomer(This method is used to create new customer profile if no customer exists with given pan number)
	 *  On successful creation, Manager creates new Bank Account for the Customer
	 *  if new customer profile is created, Log in credentials are added in Users table
	 * @param customer
	 * @return
	 */
	@PostMapping("/createcustomer")
	public Customer createCustomer(@RequestBody Customer customer){
		return managerservice.createCustomer(customer);		
	}
	
	
}
