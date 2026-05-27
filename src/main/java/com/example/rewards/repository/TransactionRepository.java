package com.example.rewards.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.rewards.model.Transaction;

// Mock repository with in-memory transaction data.

@Repository
public class TransactionRepository {

    public List<Transaction> getAllTransactions() {

        List<Transaction> transactions = new ArrayList<>();

        transactions.add(new Transaction(
                1L, 101L, "John", 120,
                LocalDate.of(2026, 1, 10)));

        transactions.add(new Transaction(
                2L, 101L, "John", 75,
                LocalDate.of(2026, 1, 15)));

        transactions.add(new Transaction(
                3L, 101L, "John", 200,
                LocalDate.of(2026, 2, 10)));

        transactions.add(new Transaction(
                4L, 102L, "David", 90,
                LocalDate.of(2026, 2, 5)));

        transactions.add(new Transaction(
                5L, 102L, "David", 140,
                LocalDate.of(2026, 3, 1)));

        transactions.add(new Transaction(
                6L, 103L, "Smith", 45,
                LocalDate.of(2026, 3, 12)));

        return transactions;
    }
}