package com.charter.reward.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charter.reward.constant.Constants;
import com.charter.reward.entity.Transaction;
import com.charter.reward.model.Rewards;
import com.charter.reward.repository.TransactionRepository;

@Service
public class RewardServiceImpl implements RewardService {

	@Autowired
	TransactionRepository transactionRepository;

	public Rewards getRewardsByCustomerNumber(Long customerNumber) {

		Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(Constants.DAYS_IN_MONTH);
		Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2 * Constants.DAYS_IN_MONTH);
		Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3 * Constants.DAYS_IN_MONTH);

		List<Transaction> lastMonthTransactions = transactionRepository.findAllByCustomerNumberAndTransactionDateBetween(
				customerNumber, lastMonthTimestamp, Timestamp.from(Instant.now()));
		List<Transaction> lastSecondMonthTransactions = transactionRepository
				.findAllByCustomerNumberAndTransactionDateBetween(customerNumber, lastSecondMonthTimestamp,
						lastMonthTimestamp);
		List<Transaction> lastThirdMonthTransactions = transactionRepository
				.findAllByCustomerNumberAndTransactionDateBetween(customerNumber, lastThirdMonthTimestamp,
						lastSecondMonthTimestamp);

		Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

		Rewards customerRewards = new Rewards();
		customerRewards.setCustomerNumber(customerNumber);
		customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
		customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
		customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
		customerRewards
				.setTotalRewardPoints(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return customerRewards;

	}

	public Timestamp getDateBasedOnOffSetDays(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}

	private Long getRewardsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculateRewards(transaction))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	private Long calculateRewards(Transaction t) {
		if (t.getTransactionAmount() > Constants.FIRST_REWARD_LIMIT
				&& t.getTransactionAmount() <= Constants.SECOND_REWARD_LIMIT) {
			return Math.round(t.getTransactionAmount() - Constants.FIRST_REWARD_LIMIT);
		} else if (t.getTransactionAmount() > Constants.SECOND_REWARD_LIMIT) {
			return Math.round(t.getTransactionAmount() - Constants.SECOND_REWARD_LIMIT) * 2
					+ (Constants.SECOND_REWARD_LIMIT - Constants.FIRST_REWARD_LIMIT);
		} else
			return 0l;

	}

}
