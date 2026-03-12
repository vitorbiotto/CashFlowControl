package com.example.CashFlowControl.service;

import com.example.CashFlowControl.entity.Category;
import com.example.CashFlowControl.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(Category category) {
        return this.categoryRepository.save(category);
    }

    public List<Category> findAll(Long userId) {
        if (userId != null)
            return this.categoryRepository.findByUserId(userId);

        return this.categoryRepository.findAll();
    }
}
