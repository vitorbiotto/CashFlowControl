package com.example.CashFlowControl.controller;

import com.example.CashFlowControl.entity.Income;
import com.example.CashFlowControl.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
@CrossOrigin(origins = "http://localhost:3000") //Permite que o react acesse a API
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public List<Income> listAll() {
        return incomeService.findAll();
    }

    @PostMapping
    public Income create(@RequestBody Income income) {
        return incomeService.save(income);
    }
}
