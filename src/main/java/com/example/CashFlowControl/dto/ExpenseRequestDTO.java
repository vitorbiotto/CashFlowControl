package com.example.CashFlowControl.dto;

import com.example.CashFlowControl.model.enums.ExpenseType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseRequestDTO {

    private String description;

    @NotNull
    @PositiveOrZero
    private BigDecimal value;

    @NotNull
    private LocalDate date;

    @NotNull
    private ExpenseType expenseType;

    public ExpenseRequestDTO() {
    }

    public ExpenseRequestDTO(String description, BigDecimal value, LocalDate date, ExpenseType expenseType) {
        this.description = description;
        this.value = value;
        this.date = date;
        this.expenseType = expenseType;
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
