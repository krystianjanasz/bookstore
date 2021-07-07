package org.example.services;

import org.example.dao.CategoryDAO;
import org.example.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryDAO.saveCategory(category);
    }

    @Override
    public Category getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    public void deleteCategory(int id) {
        //
    }
}