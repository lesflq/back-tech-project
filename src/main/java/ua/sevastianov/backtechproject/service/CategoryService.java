package ua.sevastianov.backtechproject.service;

import ua.sevastianov.backtechproject.domain.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAllCategories();
    boolean deleteCategory(Long id);
}
