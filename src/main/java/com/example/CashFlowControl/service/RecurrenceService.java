package com.example.CashFlowControl.service;

import com.example.CashFlowControl.entity.Recurrence;
import com.example.CashFlowControl.repository.RecurrenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecurrenceService {

    private final RecurrenceRepository recurrenceRepository;

    public RecurrenceService(RecurrenceRepository recurrenceRepository) {
        this.recurrenceRepository = recurrenceRepository;
    }

    public Recurrence create(Recurrence recurrence) {
        return recurrenceRepository.save(recurrence);
    }

    public List<Recurrence> findAll(Long userId) {
        if (userId != null) {
            return recurrenceRepository.findByUserId(userId);
        }
        return recurrenceRepository.findAll();
    }
}
