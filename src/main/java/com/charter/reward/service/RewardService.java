package com.charter.reward.service;

import com.charter.reward.model.Rewards;

public interface RewardService {

	public Rewards getRewardsByCustomerNumber(Long customerNumber);

}
