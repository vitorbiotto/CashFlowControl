package com.example.CashFlowControl.service;

import com.example.CashFlowControl.entity.Expense;
import com.example.CashFlowControl.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense save(Expense expense) {
        if (expense.getDate() == null) expense.setDate(LocalDate.now());

        return expenseRepository.save(expense);
    }

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }
}
