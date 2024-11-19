package ua.sevastianov.backtechproject.service;

import ua.sevastianov.backtechproject.domain.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAllCategories();
    boolean deleteCategory(Long id);
    public List<Category> getPrivateCategoriesForUser(Long userId);
    public List<Category> getGlobalCategories();
    public List<Category> getVisibleCategoriesForUser(Long userId);
}
