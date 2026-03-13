package com.example.CashFlowControl.repository;

import com.example.CashFlowControl.entity.Recurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecurrenceRepository extends JpaRepository<Recurrence, Long> {
    List<Recurrence> findByUserId(Long userId);
}
