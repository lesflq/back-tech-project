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
    @ResponseBody
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);

    }

    @GetMapping
    @ResponseBody
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "categoryId") Long categoryId) {
        if (categoryService.deleteCategory(categoryId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
