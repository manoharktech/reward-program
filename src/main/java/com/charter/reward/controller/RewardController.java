package com.charter.reward.controller;

import com.charter.reward.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charter.reward.entity.Customer;
import com.charter.reward.exception.CustomerNotFoundException;
import com.charter.reward.model.Rewards;
import com.charter.reward.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class RewardController {
	@Autowired
	RewardService rewardsService;

	@Autowired
	CustomerServiceImpl customerService;

	@GetMapping(value = "/{customerNumber}/rewards", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rewards> getRewardsByCustomerNumber(@PathVariable("customerNumber") Long customerNumber)
			throws CustomerNotFoundException {
		Customer customer = customerService.getCustomerNumber(customerNumber);

		Rewards customerRewards = rewardsService.getRewardsByCustomerNumber(customerNumber);
		return new ResponseEntity<>(customerRewards, HttpStatus.OK);
	}

}
