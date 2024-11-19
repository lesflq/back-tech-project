package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.domain.Category;
import ua.sevastianov.backtechproject.domain.CategoryType;
import ua.sevastianov.backtechproject.repositories.CategoryRepository;
import ua.sevastianov.backtechproject.service.CategoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        if (category.getType() == CategoryType.PRIVATE && category.getOwner() == null) {
            throw new IllegalArgumentException("PRIVATE category must have an owner.");
        }
        if (category.getType() == CategoryType.GLOBAL && category.getOwner() != null) {
            throw new IllegalArgumentException("GLOBAL category cannot have an owner.");
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Category> getVisibleCategoriesForUser(Long userId) {
        return categoryRepository.findVisibleCategoriesForUser(userId);
    }

    @Override
    public List<Category> getGlobalCategories() {
        return categoryRepository.findByType(CategoryType.GLOBAL);
    }

    @Override
    public List<Category> getPrivateCategoriesForUser(Long userId) {
        return categoryRepository.findByTypeAndOwner_Id(CategoryType.PRIVATE, userId);
    }
}

