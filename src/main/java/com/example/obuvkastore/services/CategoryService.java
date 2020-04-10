package com.example.obuvkastore.services;

import com.example.obuvkastore.entities.Category;
import com.example.obuvkastore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setRepository(CategoryRepository repository) {
        this.categoryRepository = repository;
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
