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

    public void deleteById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public Category updateById(Long categoryId, Category newCategory) {

        Category oldCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));

        oldCategory.setUser(newCategory.getUser());
        oldCategory.setName(newCategory.getName());
        oldCategory.setCategoryType(newCategory.getCategoryType());
        oldCategory.setColor(newCategory.getColor());

        return categoryRepository.save(oldCategory);
    }
}
