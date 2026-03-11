package com.example.CashFlowControl.service;

import com.example.CashFlowControl.entity.Transaction;
import com.example.CashFlowControl.entity.enums.TransactionType;
import com.example.CashFlowControl.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll(Long userId, LocalDate from, LocalDate to, TransactionType type, Long categoryId) {
        if (userId == null) {
            return transactionRepository.findAll();
        }
        if (from != null && to != null) {
            return transactionRepository.findByUserIdAndDueDateBetween(userId, from, to);
        }
        if (type != null) {
            return transactionRepository.findByUserIdAndType(userId, type);
        }
        if (categoryId != null) {
            return transactionRepository.findByUserIdAndCategoryId(userId, categoryId);
        }
        return transactionRepository.findByUserId(userId);
    }
}
