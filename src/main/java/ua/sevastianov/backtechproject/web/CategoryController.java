package ua.sevastianov.backtechproject.web;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.sevastianov.backtechproject.DTO.category.CategoryDTO;
import ua.sevastianov.backtechproject.domain.category.Category;
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
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        try {
            return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/visible/{userId}")
    public List<CategoryDTO> getVisibleCategories(@PathVariable Long userId) {
        return categoryService.getVisibleCategoriesForUser(userId);
    }

    @GetMapping("/global")
    public List<CategoryDTO> getGlobalCategories() {
        return categoryService.getGlobalCategories();
    }

    @GetMapping("/private/{userId}")
    public List<CategoryDTO> getPrivateCategories(@PathVariable Long userId) {
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
