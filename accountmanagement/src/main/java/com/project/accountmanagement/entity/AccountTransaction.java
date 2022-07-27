package com.project.accountmanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//account transaction
@Entity
@Table(name="AccountTransaction")
public class AccountTransaction {
	
	@Id
	@GeneratedValue
	@Column(name="TId")
	private int transactionId;
	
	@Column(name="accNumber")
	private long accountNumber;
	
	@Column(name="transactionDate")
	private Date transactionDate;
	
	@Column(name="type")
	private String type;
	
	@Column(name="subType")
	private String subType;
	
	@Column(name="currentBalance")
	private long currentBalane;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public long getCurrentBalane() {
		return currentBalane;
	}

	public void setCurrentBalane(long currentBalane) {
		this.currentBalane = currentBalane;
	}

	public AccountTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountTransaction(int transactionId, long accountNumber, Date transactionDate, String type, String subType,
			long currentBalane) {
		super();
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.transactionDate = transactionDate;
		this.type = type;
		this.subType = subType;
		this.currentBalane = currentBalane;
	}

	@Override
	public String toString() {
		return "AccountTransaction [transactionId=" + transactionId + ", accountNumber=" + accountNumber
				+ ", transactionDate=" + transactionDate + ", type=" + type + ", subType=" + subType
				+ ", currentBalane=" + currentBalane + "]";
	}
	
	
}
