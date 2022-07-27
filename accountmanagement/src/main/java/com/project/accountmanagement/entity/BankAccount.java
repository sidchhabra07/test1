package com.project.accountmanagement.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BankAccount")
public class BankAccount {
	@SequenceGenerator(name="seq",initialValue=1000000000, allocationSize=1)
	@Id
	@Column(name="accNumber")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private long accountNumber;
	
	@Column(name="customerId")
	private long customerId;
	
	@Column(name="currentBalance",columnDefinition = "int default 0")
	private long currentBalance;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(long currentBalance) {
		this.currentBalance = currentBalance;
	}

	public BankAccount(long accountNumber, long customerId, long currentBalance) {
		super();
		this.accountNumber = accountNumber;
		this.customerId = customerId;
		this.currentBalance = currentBalance;
	}

	public BankAccount() {
		super();
	}

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", customerId=" + customerId + ", currentBalance="
				+ currentBalance + "]";
	}
	
	
}
