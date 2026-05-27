package com.example.rewards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.rewards.model.CustomerRewardResponse;
import com.example.rewards.service.RewardsService;

@RestController
public class RewardsController {

    private final RewardsService rewardsService;

    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }


    @GetMapping("/api/rewards/{customerId}")
    public CustomerRewardResponse getRewards(
            @PathVariable Long customerId) {

        return rewardsService
                .getRewardsByCustomerId(customerId);
    }
}