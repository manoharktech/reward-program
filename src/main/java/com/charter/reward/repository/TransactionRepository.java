package com.charter.reward.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.charter.reward.entity.Transaction;
@EnableJpaRepositories
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	public List<Transaction> findAllByCustomerNumber(Long customerNumber);

	public List<Transaction> findAllByCustomerNumberAndTransactionDateBetween(Long customerNumber, Timestamp from,
			Timestamp to);
}