package com.example.obuvkastore.controllers;

import com.example.obuvkastore.entities.Category;
import com.example.obuvkastore.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "add_category";
    }


    @PostMapping("/add_category")
    public String addProducerSubmit(@Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "add_category";
        } else {
            categoryService.saveCategory(category);
            return "redirect:/categories";
        }
    }
}