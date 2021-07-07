package org.example.dao;

import org.example.entity.Book;
import org.example.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getCategories();
    void saveCategory(Category category);
    Category getCategory(int category_id);
    void deleteCategory(int category_id);
}
