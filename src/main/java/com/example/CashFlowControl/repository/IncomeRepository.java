package com.example.CashFlowControl.repository;

import com.example.CashFlowControl.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {

    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(income.value) " +
            "FROM Income income " +
            "WHERE income.date BETWEEN :startDate AND :endDate")
    Double sumValueByDateBetween(@Param("startDate") LocalDate startDate,
                                 @Param("endDate") LocalDate endDate);
}
