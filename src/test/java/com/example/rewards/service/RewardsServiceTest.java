package com.example.rewards.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.rewards.repository.TransactionRepository;

class RewardsServiceTest {

    private RewardsService rewardsService;

    @BeforeEach
    void setup() {
        rewardsService =
                new RewardsService(
                        new TransactionRepository());
    }

    @Test
    void testRewardCalculationFor120() {

        int points =
                rewardsService.calculateRewardPoints(120);

        assertEquals(90, points);
    }

    @Test
    void testRewardCalculationFor75() {

        int points =
                rewardsService.calculateRewardPoints(75);

        assertEquals(25, points);
    }

    @Test
    void testRewardCalculationFor45() {

        int points =
                rewardsService.calculateRewardPoints(45);

        assertEquals(0, points);
    }

    @Test
    void testNegativeAmount() {

        assertThrows(
                IllegalArgumentException.class,
                () -> rewardsService
                        .calculateRewardPoints(-100));
    }
}