package com.example.CashFlowControl.dto;

import com.example.CashFlowControl.model.enums.IncomeType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IncomeRequestDTO {

    private String description;

    @NotNull
    @PositiveOrZero
    private BigDecimal value;

    @NotNull
    private LocalDate date;

    @NotNull
    private IncomeType incomeType;

    public IncomeRequestDTO() {
    }

    public IncomeRequestDTO(String description, BigDecimal value, LocalDate date, IncomeType incomeType) {
        this.description = description;
        this.value = value;
        this.date = date;
        this.incomeType = incomeType;
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

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }
}
