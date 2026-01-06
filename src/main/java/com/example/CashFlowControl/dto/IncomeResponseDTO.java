package com.example.CashFlowControl.dto;

import com.example.CashFlowControl.model.Income;
import com.example.CashFlowControl.model.enums.IncomeType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IncomeResponseDTO {

    private Long id;
    private String description;
    private BigDecimal value;
    private LocalDate date;
    private IncomeType incomeType;

    public IncomeResponseDTO() {
    }

    public IncomeResponseDTO(Income income) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.date = date;
        this.incomeType = incomeType;
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

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }
}
