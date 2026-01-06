package com.example.CashFlowControl.model;

import com.example.CashFlowControl.model.enums.IncomeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "value")
    private BigDecimal value;

    @NotNull
    @Column(name = "incomeType")
    @Enumerated(EnumType.STRING)
    private IncomeType incomeType;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Income() {
    }

    public Income(Long id, BigDecimal value, IncomeType incomeType, LocalDate date, String description, User user) {
        this.id = id;
        this.value = value;
        this.incomeType = incomeType;
        this.date = date;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
