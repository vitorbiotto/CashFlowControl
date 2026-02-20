package com.example.CashFlowControl.service;

import com.example.CashFlowControl.entity.Income;
import com.example.CashFlowControl.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public Income save(Income income) {
        if (income.getDate() == null) income.setDate(LocalDate.now());

        return incomeRepository.save(income);
    }

    public List<Income> findAll() {
        return incomeRepository.findAll();
    }
}
