package ua.sevastianov.backtechproject.DTO.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    String name;

    @NotNull(message = "Category type cannot be null")
    CategoryType type;

    Long ownerId;
}