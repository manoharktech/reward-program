package com.charter.reward.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

	public Customer(long l, String string) {
		this.customerNumber=l;
		this.customerName=string;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_NUMBER")
	private Long customerNumber;
	
	@Column(name = "CUSTOMER_NAME")
	private String customerName;

}
