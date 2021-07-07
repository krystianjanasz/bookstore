package org.example.controller;

import org.example.entity.Category;
import org.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        return "categories/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("category", new Category());

        return "categories/form";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("category")Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories/list";
    }
}
