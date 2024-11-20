package ua.sevastianov.backtechproject.mapper;

import ua.sevastianov.backtechproject.DTO.category.CategoryDTO;
import ua.sevastianov.backtechproject.domain.category.Category;

public interface CategoryMapper {
    Category toEntity(CategoryDTO categoryDTO);

    CategoryDTO toDTO(Category category);

}
