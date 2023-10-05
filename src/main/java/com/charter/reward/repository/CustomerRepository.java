package com.charter.reward.repository;

import com.charter.reward.entity.Customer;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
@EnableJpaRepositories
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	public Customer findByCustomerNumber(Long customerNumber);
}
