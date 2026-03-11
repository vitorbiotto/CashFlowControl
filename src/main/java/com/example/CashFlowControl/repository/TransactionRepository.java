package com.example.CashFlowControl.repository;

import com.example.CashFlowControl.entity.Transaction;
import com.example.CashFlowControl.entity.enums.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByUserIdAndDueDateBetween(Long userId, LocalDate from, LocalDate to);

    List<Transaction> findByUserIdAndType(Long userId, TransactionType type);

    List<Transaction> findByUserIdAndCategoryId(Long userId, Long categoryId);
}
