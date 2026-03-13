package com.example.CashFlowControl.service;

import com.example.CashFlowControl.entity.Transaction;
import com.example.CashFlowControl.entity.User;
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

    public List<Transaction> findAll(Long userId,
                                     LocalDate from,
                                     LocalDate to,
                                     TransactionType type,
                                     Long categoryId) {
        if (userId == null) return this.transactionRepository.findAll();

        if (from != null && to != null)
            return transactionRepository.findByUserIdAndDueDateBetween(userId, from, to);

        if (type != null) return transactionRepository.findByUserIdAndType(userId, type);

        if (categoryId != null) return transactionRepository.findByUserIdAndCategoryId(userId, categoryId);

        return transactionRepository.findByUserId(userId);
    }

    public void deleteById(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }

    public Transaction updateById(Long transactionId, Transaction newTransaction) {

        Transaction oldTransaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + transactionId));

        oldTransaction.setUser(newTransaction.getUser());
        oldTransaction.setCategory(newTransaction.getCategory());
        oldTransaction.setType(newTransaction.getType());
        oldTransaction.setDescription(newTransaction.getDescription());
        oldTransaction.setAmount(newTransaction.getAmount());
        oldTransaction.setDueDate(newTransaction.getDueDate());
        oldTransaction.setPaidDate(newTransaction.getPaidDate());
        oldTransaction.setRecurrence(newTransaction.getRecurrence());

        return transactionRepository.save(oldTransaction);
    }
}
