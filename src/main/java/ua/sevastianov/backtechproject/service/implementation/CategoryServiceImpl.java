package ua.sevastianov.backtechproject.service.implementation;

import org.springframework.stereotype.Service;
import ua.sevastianov.backtechproject.DTO.category.CategoryDTO;
import ua.sevastianov.backtechproject.domain.category.Category;
import ua.sevastianov.backtechproject.domain.category.CategoryType;
import ua.sevastianov.backtechproject.mapper.CategoryMapper;
import ua.sevastianov.backtechproject.repositories.CategoryRepository;
import ua.sevastianov.backtechproject.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.getType() == CategoryType.PRIVATE && categoryDTO.getOwnerId() == null) {
            throw new IllegalArgumentException("PRIVATE category must have an owner.");
        }
        if (categoryDTO.getType() == CategoryType.GLOBAL && categoryDTO.getOwnerId() != null) {
            throw new IllegalArgumentException("GLOBAL category cannot have an owner.");
        }
        System.out.println("Type DTO: " + categoryDTO.getType());
        Category category = categoryMapper.toEntity(categoryDTO);
        System.out.println("Type Default: " + category.getType());
        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toDTO(savedCategory);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
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
    public List<CategoryDTO> getVisibleCategoriesForUser(Long userId) {
        return categoryRepository.findVisibleCategoriesForUser(userId).stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getGlobalCategories() {
        return categoryRepository.findByType(CategoryType.GLOBAL).stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> getPrivateCategoriesForUser(Long userId) {
        return categoryRepository.findByTypeAndOwner_Id(CategoryType.PRIVATE, userId).stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}


