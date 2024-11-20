package ua.sevastianov.backtechproject.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.sevastianov.backtechproject.DTO.category.CategoryDTO;
import ua.sevastianov.backtechproject.domain.category.Category;
import ua.sevastianov.backtechproject.domain.customer.Customer;
import ua.sevastianov.backtechproject.mapper.CategoryMapper;
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toEntity(CategoryDTO categoryDTO) {
        if(categoryDTO == null) return null;
        return Category.builder().id(categoryDTO.getId()).name(categoryDTO.getName())
                .owner(categoryDTO.getOwnerId() != null
                        ? Customer.builder().id(categoryDTO.getOwnerId()).build()
                        : null)
                .build();
    }

    @Override
    public CategoryDTO toDTO(Category category) {
        if(category == null) return null;
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .type(category.getType())
                .ownerId(category.getOwner() != null ? category.getOwner().getId() : null)
                .build();
    }
}
