package ua.sevastianov.backtechproject.DTO.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CustomerDTO {
    Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    String name;
}
