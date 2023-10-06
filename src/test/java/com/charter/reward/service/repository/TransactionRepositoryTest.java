package com.charter.reward.service.repository;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.charter.reward.entity.Customer;
import com.charter.reward.entity.Transaction;
import com.charter.reward.repository.CustomerRepository;
import com.charter.reward.repository.TransactionRepository;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class TransactionRepositoryTest {

	@Autowired
	TransactionRepository transRepository;

    @BeforeEach
    public void setUp() {
    	transRepository.save(new Transaction(1001L,101L,Timestamp.valueOf("2023-08-12"),126));
    	transRepository.save(new Transaction(1002L,101L,Timestamp.valueOf("2023-08-13"),123));
    }

    @AfterEach
    public void destroy() {
    	transRepository.deleteAll();
    }
}
