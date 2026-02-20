package com.example.CashFlowControl.controller;

import com.example.CashFlowControl.entity.Expense;
import com.example.CashFlowControl.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:3000") //Permite que o react acesse a API
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> listAll() {
        return expenseService.findAll();
    }

    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }
}
