package com.example.CashFlowControl.model;

import com.example.CashFlowControl.model.enums.ExpenseType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "value")
    private BigDecimal value;

    @NotNull
    @Column(name = "expenseType")
    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Expense() {
    }

    public Expense(Long id, BigDecimal value, ExpenseType expenseType, LocalDate date, String description, User user) {
        this.id = id;
        this.value = value;
        this.expenseType = expenseType;
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

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
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
