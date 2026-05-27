package com.example.rewards.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.rewards.exception.CustomerNotFoundException;
import com.example.rewards.model.CustomerRewardResponse;
import com.example.rewards.model.MonthlyReward;
import com.example.rewards.model.Transaction;
import com.example.rewards.repository.TransactionRepository;


@Service
public class RewardsService {

    private final TransactionRepository repository;

    public RewardsService(TransactionRepository repository) {
        this.repository = repository;
    }

    public CustomerRewardResponse getRewardsByCustomerId(Long customerId) {

        List<Transaction> customerTransactions =
                repository.getAllTransactions()
                        .stream()
                        .filter(transaction ->
                                transaction.getCustomerId()
                                        .equals(customerId))
                        .toList();

        if (customerTransactions.isEmpty()) {
            throw new CustomerNotFoundException(
                    "Customer not found with id: " + customerId);
        }

        Map<Month, Integer> monthlyRewardsMap =
                customerTransactions.stream()
                        .collect(Collectors.groupingBy(
                                transaction ->
                                        transaction.getTransactionDate()
                                                .getMonth(),
                                Collectors.summingInt(
                                        transaction ->
                                                calculateRewardPoints(
                                                        transaction.getAmount())
                                )));

        List<MonthlyReward> monthlyRewards =
                new ArrayList<>();

        int totalRewards = 0;

        for (Map.Entry<Month, Integer> entry :
                monthlyRewardsMap.entrySet()) {

            monthlyRewards.add(
                    new MonthlyReward(
                            entry.getKey().name(),
                            entry.getValue()));

            totalRewards += entry.getValue();
        }

        Transaction firstTransaction =
                customerTransactions.get(0);

        return new CustomerRewardResponse(
                customerId,
                firstTransaction.getCustomerName(),
                monthlyRewards,
                totalRewards);
    }

// Calculates reward points.

    public int calculateRewardPoints(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Amount cannot be negative");
        }

        int points = 0;

        if (amount > 100) {
            points += (int) ((amount - 100) * 2);
            points += 50;
        } else if (amount > 50) {
            points += (int) (amount - 50);
        }

        return points;
    }
}