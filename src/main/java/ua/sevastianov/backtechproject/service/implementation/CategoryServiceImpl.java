package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.domain.Category;
import ua.sevastianov.backtechproject.service.CategoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CategoryServiceImpl implements CategoryService {
    private Map<Long, Category> categories = new HashMap<>();
    private long nextId = 1L;

    public Category createCategory(Category category) {
        category = category.toBuilder().id(nextId++).build();
        categories.put(category.getId(), category);
        return category;
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    public boolean deleteCategory(Long id) {
        return categories.remove(id) != null;
    }
}
