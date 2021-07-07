package org.example.services;

import org.example.dao.CategoryDAO;
import org.example.entity.Book;
import org.example.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CategoryService {



    List<Category> getCategories();
    void saveCategory(Category category);
    Category getCategory(int category_id);
    void deleteCategory(int category_id);
}
