package ua.sevastianov.backtechproject.service;

import ua.sevastianov.backtechproject.DTO.category.CategoryDTO;
import ua.sevastianov.backtechproject.domain.category.Category;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO category);
    List<CategoryDTO> getAllCategories();
    boolean deleteCategory(Long id);
    List<CategoryDTO> getPrivateCategoriesForUser(Long userId);
    List<CategoryDTO> getGlobalCategories();
    List<CategoryDTO> getVisibleCategoriesForUser(Long userId);
}
