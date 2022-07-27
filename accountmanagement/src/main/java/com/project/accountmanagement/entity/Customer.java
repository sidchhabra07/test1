package com.project.accountmanagement.entity;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	@SequenceGenerator(name="seq",initialValue=100000, allocationSize=1)
	@Id
	@Column(name="Cid")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private long cId;

	@Column(name = "Cname")
	private String customerName;
	
	@Column(name="dateOfBirth")
	private LocalDate dateOfBirth;
	
	@Column(name="panNumber")
	private String panNumber;
	
	@Column(name="aadharNumber")
	private String aadherNumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	public long getcId() {
		return cId;
	}

	public void setcId(long cId) {
		this.cId = cId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadherNumber() {
		return aadherNumber;
	}

	public void setAadherNumber(String aadherNumber) {
		this.aadherNumber = aadherNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer() {
		super();
	}

	public Customer(
			long cId, 
			String customerName, LocalDate dateOfBirth, String panNumber, String aadherNumber,
			String address, String email) {
		super();
		this.cId = cId;
		this.customerName = customerName;
		this.dateOfBirth = dateOfBirth;
		this.panNumber = panNumber;
		this.aadherNumber = aadherNumber;
		this.address = address;
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", customerName=" + customerName + ", dateOfBirth=" + dateOfBirth
				+ ", panNumber=" + panNumber + ", aadherNumber=" + aadherNumber + ", address=" + address + ", email="
				+ email + "]";
	}
	
}
