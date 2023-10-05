package com.charter.reward.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.reward.entity.Customer;
import com.charter.reward.exception.CustomerNotFoundException;
import com.charter.reward.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired()
	CustomerRepository customerRepository;

	@Override
	public Customer getCustomerNumber(Long customerNumber) throws CustomerNotFoundException {

		Customer customer = customerRepository.findByCustomerNumber(customerNumber);
		if (customer == null) {
			throw new CustomerNotFoundException();
		}
		return customer;
	}

}
