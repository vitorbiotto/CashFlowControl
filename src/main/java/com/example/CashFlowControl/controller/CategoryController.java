package com.example.CashFlowControl.controller;

import com.example.CashFlowControl.entity.Category;
import com.example.CashFlowControl.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vq/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    @GetMapping
    public List<Category> findAll(@RequestParam(required = false) Long userId) {
        return categoryService.findAll(userId);
    }
}
