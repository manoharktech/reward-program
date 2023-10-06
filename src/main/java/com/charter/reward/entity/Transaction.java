package com.charter.reward.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRANSACTION_NUMBER")
	private Long transactionNumber;

	@Column(name = "CUSTOMER_NUMBER")
	private Long customerNumber;

	@Column(name = "TRANSACTION_DATE")
	private Timestamp transactionDate;

	@Column(name = "AMOUNT")
	private double transactionAmount;

	public Transaction(long l, long custNum, Timestamp transactionDate,double transactionAmount) {
		this.transactionNumber=l;
		this.customerNumber=custNum;
		this.transactionDate=transactionDate;
		this.transactionAmount=transactionAmount;

	}

	public Long getTransactionId() {
		return transactionNumber;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionNumber = transactionId;
	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
}
