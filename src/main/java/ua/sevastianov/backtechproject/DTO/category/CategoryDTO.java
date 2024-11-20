package ua.sevastianov.backtechproject.DTO.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import ua.sevastianov.backtechproject.domain.category.CategoryType;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CategoryDTO {
    Long id;
    String name;
    CategoryType type;
    Long ownerId;
}