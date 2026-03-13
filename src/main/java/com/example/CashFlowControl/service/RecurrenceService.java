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
        return this.recurrenceRepository.save(recurrence);
    }

    public List<Recurrence> findAll(Long userId) {
        if (userId != null) return this.recurrenceRepository.findByUserId(userId);

        return this.recurrenceRepository.findAll();
    }

    public void deleteById(Long recurrenceId) {
        this.recurrenceRepository.deleteById(recurrenceId);
    }

    public Recurrence updateById(Long recurrenceId, Recurrence newRecurrence) {

        Recurrence oldRecurrence = recurrenceRepository.findById(recurrenceId)
                .orElseThrow(() -> new RuntimeException("Recurrence not found with id " + recurrenceId));

        oldRecurrence.setUser(newRecurrence.getUser());
        oldRecurrence.setStartDate(newRecurrence.getStartDate());
        oldRecurrence.setRecurrenceFrequency(newRecurrence.getRecurrenceFrequency());
        oldRecurrence.setIntervalValue(newRecurrence.getIntervalValue());
        oldRecurrence.setDueDate(newRecurrence.getDueDate());
        oldRecurrence.setActive(newRecurrence.getActive());

        return recurrenceRepository.save(oldRecurrence);
    }
}
