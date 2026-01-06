package com.example.CashFlowControl.repository;

import com.example.CashFlowControl.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(expense.value) " +
            "FROM Expense expense " +
            "WHERE expense.date BETWEEN :startDate AND :endDate")
    Double sumValueByDateBetween(@Param("startDate") LocalDate startDate,
                                 @Param("endDate") LocalDate endDate);

}