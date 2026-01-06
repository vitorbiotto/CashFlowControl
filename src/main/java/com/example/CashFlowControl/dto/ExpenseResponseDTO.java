package com.example.CashFlowControl.dto;

import com.example.CashFlowControl.model.Expense;
import com.example.CashFlowControl.model.enums.ExpenseType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseResponseDTO {
    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDate date;
    private ExpenseType expenseType;

    public ExpenseResponseDTO() {
    }

    public ExpenseResponseDTO(Expense expense) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.date = date;
        this.expenseType = expenseType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}
