package com.example.CashFlowControl.repository;

import com.example.CashFlowControl.entity.Recurrence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecurrenceRepository extends JpaRepository<Recurrence, Long> {
    List<Recurrence> findByUserId(Long userId);
}
