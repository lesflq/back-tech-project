package ua.sevastianov.backtechproject.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.sevastianov.backtechproject.domain.Category;
import ua.sevastianov.backtechproject.service.implementation.CategoryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        try {
            return ResponseEntity.ok(categoryService.createCategory(category));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/visible/{userId}")
    public List<Category> getVisibleCategories(@PathVariable Long userId) {
        return categoryService.getVisibleCategoriesForUser(userId);
    }

    @GetMapping("/global")
    public List<Category> getGlobalCategories() {
        return categoryService.getGlobalCategories();
    }

    @GetMapping("/private/{userId}")
    public List<Category> getPrivateCategories(@PathVariable Long userId) {
        return categoryService.getPrivateCategoriesForUser(userId);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "categoryId") Long categoryId) {
        if (categoryService.deleteCategory(categoryId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
