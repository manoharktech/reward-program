package com.charter.reward.service.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.charter.reward.entity.Customer;
import com.charter.reward.repository.CustomerRepository;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository custRepository;

    @BeforeEach
    public void setUp() {
    	custRepository.save(new Customer(101L, "jane"));
    	custRepository.save(new Customer(102L, "Sudan"));
    }

    @AfterEach
    public void destroy() {
    	custRepository.deleteAll();
    }
}
