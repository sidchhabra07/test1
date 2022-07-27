package com.project.accountmanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.accountmanagement.AccountmanagementApplication;

/**
 * Exception handling 
 * @author srapu
 *
 */
public class ValueNotFoundException extends RuntimeException{
	private static Logger LOGGER = LoggerFactory.getLogger(AccountmanagementApplication.class);

	private static final long serialVersionUID = 1L;
	public ValueNotFoundException(String string) {
		super(string);
		LOGGER.info(string);
	}
	public ValueNotFoundException() {
		
	}

}
