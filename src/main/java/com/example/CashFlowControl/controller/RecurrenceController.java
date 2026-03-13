package com.example.CashFlowControl.controller;

import com.example.CashFlowControl.entity.Recurrence;
import com.example.CashFlowControl.service.RecurrenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recurrences")
@CrossOrigin(origins = "http://localhost:5173")
public class RecurrenceController {

    private final RecurrenceService recurrenceService;

    public RecurrenceController(RecurrenceService recurrenceService) {
        this.recurrenceService = recurrenceService;
    }

    @PostMapping
    public Recurrence create(@RequestBody Recurrence recurrence) {
        return recurrenceService.create(recurrence);
    }

    @GetMapping
    public List<Recurrence> findAll(@RequestParam(required = false) Long userId) {
        return recurrenceService.findAll(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@RequestParam Long recurrenceId) {
        recurrenceService.deleteById(recurrenceId);
    }

    @PutMapping("/{id}")
    public Recurrence updateById(@PathVariable Long recurrenceId,
                                 @RequestBody Recurrence recurrence) {
        return recurrenceService.updateById(recurrenceId, recurrence);
    }
}
